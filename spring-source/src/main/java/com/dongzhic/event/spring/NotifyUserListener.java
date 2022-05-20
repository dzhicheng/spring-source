package com.dongzhic.event.spring;

import com.dongzhic.pojo.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 用户注册成功，发送短信监听
 * @Author dongzhic
 * @Date 2022/5/19 10:18
 */
@Component
public class NotifyUserListener implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        User user = (User) event.getSource();
        System.out.println("用户注册成功，发送短信监听, " + user.getName());
    }
}
