package com.dongzhic.event.service;

/**
 * 观察者抽象类
 * @Author dongzhic
 * @Date 2022/5/18 23:50
 */
public interface Observer {
    /**
     * 发送天气预报
     */
    void sendWeatherWarning();
}
