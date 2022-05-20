package com.dongzhic.event.spring.annotation;

import com.dongzhic.event.spring.UserRegisterEvent;
import com.dongzhic.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * 发布监听
 *  spring4.2之后，ApplicationEventPublisher会被自动注入到容器
 * @Author dongzhic
 * @Date 2022/5/19 10:56
 */
@Service("userRegisterPublisherService")
public class UserRegisterPublisherService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void insertUser () {
        UserRegisterEvent userRegisterEvent = new UserRegisterEvent(new User("lisi", "119"));
        applicationEventPublisher.publishEvent(userRegisterEvent);
    }
}
