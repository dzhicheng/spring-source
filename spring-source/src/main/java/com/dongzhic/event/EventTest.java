package com.dongzhic.event;

import com.dongzhic.bean.ComponentScanOneBean;
import com.dongzhic.event.java.CloseDoorListener;
import com.dongzhic.event.java.DoorEvent;
import com.dongzhic.event.java.DoorListener;
import com.dongzhic.event.java.OpenDoorListener;
import com.dongzhic.event.service.impl.BeijingWeather;
import com.dongzhic.event.spring.annotation.UserRegisterPublisherService;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dongzhic
 * @Date 2022/5/18 23:58
 */
public class EventTest {

    private static ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

    public static void main(String[] args) {
        // 观察者模式测试
        BeijingWeather beijingWeather = new BeijingWeather();
        beijingWeather.publishWeatherInfo();
    }

    @Test
    public void sprigEventTest () {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.dongzhic");
        UserRegisterPublisherService userRegisterPublisherService = (UserRegisterPublisherService) applicationContext.getBean("userRegisterPublisherService");
        userRegisterPublisherService.insertUser();
    }

    /**
     * java事件测试
     */
    @Test
    public void javaEventTest () {
        DoorEvent doorEvent = new DoorEvent("open", 1);
        List<DoorListener> doorListenerList = getAllListener ();
        for (DoorListener doorListener : doorListenerList) {
            doorListener.doorEvent(doorEvent);
        }
    }
    /**
     * 注册开关门事件
     * @return
     */
    private List<DoorListener> getAllListener () {
        List<DoorListener> doorListenerList = new ArrayList<>();
        doorListenerList.add(new CloseDoorListener());
        doorListenerList.add(new OpenDoorListener());
        return doorListenerList;
    }


}
