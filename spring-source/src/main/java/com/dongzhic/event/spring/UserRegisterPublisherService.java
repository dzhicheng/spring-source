package com.dongzhic.event.spring;

import com.dongzhic.pojo.User;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * 发布监听
 * @Author dongzhic
 * @Date 2022/5/19 10:32
 */
@Service("UserRegisterPublisherService1")
public class UserRegisterPublisherService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void insertUser () {
        UserRegisterEvent userRegisterEvent = new UserRegisterEvent(new User("zhangsan", "110"));
        applicationEventPublisher.publishEvent(userRegisterEvent);
    }
}
