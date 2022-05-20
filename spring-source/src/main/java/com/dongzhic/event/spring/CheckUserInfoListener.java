package com.dongzhic.event.spring;

import com.dongzhic.pojo.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 用户注册成功，检查用户信息监听
 * @Author dongzhic
 * @Date 2022/5/19 10:16
 */
@Component
public class CheckUserInfoListener implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        User user = (User) event.getSource();
        System.out.println("用户注册成功，检查用户信息监听, " + user.getName());
    }
}
