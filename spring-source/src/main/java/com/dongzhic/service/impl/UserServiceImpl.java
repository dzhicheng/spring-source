package com.dongzhic.service.impl;

import com.dongzhic.service.AccountService;
import com.dongzhic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author dongzhic
 * @Date 7/13/21 8:04 AM
 */
@Primary
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AccountService accountService;

    @Override
    public String queryUser(String userId) {
        System.out.println("UserServiceImpl ->" + userId);
        return "UserServiceImpl ->" + userId;
    }

    @Transactional
    public void addUser () {

    }
}
