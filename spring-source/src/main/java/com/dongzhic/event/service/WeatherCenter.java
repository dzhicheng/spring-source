package com.dongzhic.event.service;

/**
 * 被观察者抽象类：气象中心
 * @Author dongzhic
 * @Date 2022/5/18 23:53
 */
public interface WeatherCenter {
    /**
     * 推送天气信息
     */
    void publishWeatherInfo();
}
