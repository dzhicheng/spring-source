package com.dongzhic.service.impl;

import com.dongzhic.annotation.TargetSource;
import com.dongzhic.service.AccountService;
import com.dongzhic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author dongzhic
 * @Date 7/14/21 5:56 PM
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserService userService;

    /**
     * 选择数据源的方式，不推荐
     * @param id
     * @return
     */
    @Transactional
    @TargetSource("ds1")
    @Override
    public String queryAccount (String id) {
        System.out.println("=========AccountServiceImpl.queryAccount=========");
        return "=========AccountServiceImpl.queryAccount=========";
    }
}
