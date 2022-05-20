package com.dongzhic.event.spring;

import com.dongzhic.pojo.User;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;

/**
 * 用户注册有序监听
 * @Author dongzhic
 * @Date 2022/5/19 10:48
 */
public class CheckUserInfoListenerOfOrder implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == UserRegisterEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType == User.class;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        User user = (User) event.getSource();
        System.out.println("用户注册有序监听, " + user.getName());
    }
}
