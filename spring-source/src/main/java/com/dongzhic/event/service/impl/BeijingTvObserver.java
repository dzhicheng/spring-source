package com.dongzhic.event.service.impl;

import com.dongzhic.event.service.Observer;

/**
 * 观察者实现类
 * @Author dongzhic
 * @Date 2022/5/18 23:51
 */
public class BeijingTvObserver implements Observer {

    @Override
    public void sendWeatherWarning() {
        System.out.println("北京卫视天气预报开始了");
    }
}
