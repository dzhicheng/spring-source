package com.dongzhic.design.pattern.strategy;

import org.springframework.stereotype.Component;

/**
 * 四川
 * @Author dongzhic
 * @Date 7/22/21 10:14 PM
 */
@Component
public class CS implements Province {

    private static String flag = "CS";


    @Override
    public boolean support(String flag) {
        return CS.flag.equalsIgnoreCase(flag);
    }

    @Override
    public String handler() {
        System.out.println("=============HN处理类处理");
        return null;
    }
}
