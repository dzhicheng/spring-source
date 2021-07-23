package com.dongzhic.bean;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author dongzhic
 * @Date 7/5/21 5:51 PM
 */
@Service
public class PostConstructDemo {


    /**
     * bean实例化后调用
     */
    @PostConstruct
    public void init () {
        System.out.println("====================PostConstructDemo.init=============================");
    }

    /**
     * bean销毁前调用
     */
    @PreDestroy
    public void destroy () {
        System.out.println("====================PostConstructDemo.destroy=============================");
    }
}
