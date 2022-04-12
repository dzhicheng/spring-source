package com.dongzhic.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author dongzhic
 * @Date 7/14/21 10:35 AM
 */
@Component
public class Order {

    /**
     * 从三级缓存拿的order的bean对象
     */
    @Autowired
    private Order order;

    @Transactional(propagation = Propagation.REQUIRED)
    public void queryOrder () {

        // addOrder的事务注解不生效，没有走切面，没有用代理实例
        addOrder();

        // 正确的做法,先把自己注入本类
        order.addOrder();
    }

    @Transactional
    public void addOrder () {

    }
}
