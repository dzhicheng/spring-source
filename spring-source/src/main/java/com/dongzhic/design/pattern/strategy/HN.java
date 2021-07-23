package com.dongzhic.design.pattern.strategy;

import org.springframework.stereotype.Component;

/**
 * 湖南
 * @Author dongzhic
 * @Date 7/22/21 10:14 PM
 */
@Component
public class HN implements Province {

    private static String flag = "HN";


    @Override
    public boolean support(String flag) {
        return HN.flag.equalsIgnoreCase(flag);
    }

    @Override
    public String handler() {
        System.out.println("=============HN处理类处理");
        return null;
    }
}
