package com.dongzhic.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author dongzhic
 * @Date 7/7/21 3:39 PM
 */
public class CircularRefC {

    @Autowired
    private CircularRefA circularRefA;

    public CircularRefC() {
        System.out.println("===============CircularRefC()======================");
    }
}
