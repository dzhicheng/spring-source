package com.dongzhic.event.spring.annotation;

import com.dongzhic.event.spring.UserRegisterEvent;
import com.dongzhic.pojo.User;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 监听注册
 * @Author dongzhic
 * @Date 2022/5/19 10:56
 */
@Service
public class ListenerRegister {

    @Async
    @EventListener
    @Order(0)
    public void checkUserInfo (UserRegisterEvent userRegisterEvent) {
        User user = (User) userRegisterEvent.getSource();
        System.out.println("用户注册成功，检查用户信息监听, " + user.getName());
    }
}
