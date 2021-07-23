package com.dongzhic.service.impl;

import com.dongzhic.dao.CommonMapper;
import com.dongzhic.pojo.ZgTicket;
import com.dongzhic.service.TransactionService;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.framework.AopProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author dongzhic
 * @Date 7/19/21 9:53 AM
 */
public class TransactionServiceImpl implements TransactionService {


    @Autowired
    private CommonMapper commonMapper;
    @Autowired
    private TransactionTemplate transactionTemplate;
    @Autowired
    private PlatformTransactionManager platformTransactionManager;


    @Transactional
    @Override
    public int getTicket () {

        // 1.获取锁
        List<ZgTicket> zgTickets = commonMapper.queryTicketById("12306");
        Map<String, Object> param = new HashMap<>();
        param.put("ticketId", "12306");
        param.put("version", zgTickets.get(0).getVersion());
        int i = commonMapper.updateLock(param);

        if (i > 0) {
            // 2.抢票
            ZgTicket zgTicket = zgTickets.get(0);
            zgTicket.setTicketCount(2);
            int i2 = commonMapper.updateTicket(zgTicket);
        } else {
            // 继续抢
            ((TransactionService)AopContext.currentProxy()).getTicket();
        }

        return 0;
    }

    /**
     * 编程式事务：控制力度细
     * @return
     */
    @Override
    public int getTicketModeOne() {

        // 开启事务，执行结束提交事务
        Integer execute = transactionTemplate.execute(status -> {
            // 1.获取锁
            List<ZgTicket> zgTickets = commonMapper.queryTicketById("12306");
            Map<String, Object> param = new HashMap<>();
            param.put("ticketId", "12306");
            param.put("version", zgTickets.get(0).getVersion());
            int i = commonMapper.updateLock(param);

            if (i > 0) {
                // 2.抢票
                ZgTicket zgTicket = zgTickets.get(0);
                zgTicket.setTicketCount(2);
                int i2 = commonMapper.updateTicket(zgTicket);
            }

            return i;
        });

        if (execute == 0) {
            // 失败，继续抢
            getTicketModeOne();
        }

        return 0;
    }

    /**
     * 自己调用spring的事务
     */
    public void diyTransaction () {

        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setPropagationBehavior(0);
        TransactionStatus transaction = platformTransactionManager.getTransaction(defaultTransactionDefinition);

        try{
            // 业务代码
            System.out.println("===================业务代码=====================");
        } catch (Exception e) {
            platformTransactionManager.rollback(transaction);
        }

        platformTransactionManager.commit(transaction);
    }
}
