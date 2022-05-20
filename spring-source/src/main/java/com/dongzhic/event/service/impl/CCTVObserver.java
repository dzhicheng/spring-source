package com.dongzhic.event.service.impl;

import com.dongzhic.event.service.Observer;

/**
 * 观察者实现类
 * @Author dongzhic
 * @Date 2022/5/18 23:52
 */
public class CCTVObserver implements Observer {

    @Override
    public void sendWeatherWarning() {
        System.out.println("中央电视台天气预报开始了");
    }
}
