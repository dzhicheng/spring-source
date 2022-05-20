package com.dongzhic.event.spring;

import org.springframework.context.ApplicationEvent;

/**
 * 用户注册事件
 * @Author dongzhic
 * @Date 2022/5/19 10:15
 */
public class UserRegisterEvent extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public UserRegisterEvent(Object source) {
        super(source);
    }
}
