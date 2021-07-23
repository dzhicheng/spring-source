package com.dongzhic.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author dongzhic
 * @Date 7/21/21 6:01 PM
 */
@Component
public class FinishEvent implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("====================spring加载完成后调用=====================");
    }
}
