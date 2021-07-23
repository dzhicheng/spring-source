package com.dongzhic.design.pattern.strategy;

import org.springframework.stereotype.Component;

/**
 * 湖北
 * @Author dongzhic
 * @Date 7/22/21 10:14 PM
 */
@Component
public class HB implements Province {

    private static String flag = "HB";


    @Override
    public boolean support(String flag) {
        return HB.flag.equalsIgnoreCase(flag);
    }

    @Override
    public String handler() {
        System.out.println("=============HB处理类处理");
        return null;
    }
}
