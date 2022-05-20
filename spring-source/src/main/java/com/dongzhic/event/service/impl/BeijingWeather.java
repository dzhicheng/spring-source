package com.dongzhic.event.service.impl;

import com.dongzhic.event.service.Observer;
import com.dongzhic.event.service.WeatherCenter;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者实现类：北京气象中心
 * @Author dongzhic
 * @Date 2022/5/18 23:55
 */
public class BeijingWeather implements WeatherCenter {

    private static List<Observer> observerList = new ArrayList<>();
    static {
        observerList.add(new BeijingTvObserver());
        observerList.add(new CCTVObserver());
    }

    @Override
    public void publishWeatherInfo() {
        for (Observer observer : observerList) {
            observer.sendWeatherWarning();
        }
    }
}
