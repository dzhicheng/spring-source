package com.dongzhic.design.pattern.strategy;

import com.dongzhic.bean.ComponentScanBean;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * 策略模式
 * @Author dongzhic
 * @Date 7/22/21 10:11 PM
 */
public class StrategyTest {

    private ApplicationContext applicationContext;

    @Before
    public void before () {
        applicationContext = new AnnotationConfigApplicationContext(ComponentScanBean.class);
    }

    /**
     * 使用策略模式
     */
    @Test
    public void designPattern () {
        String flag = "CQ";

        Map<String, Province> beansOfType = applicationContext.getBeansOfType(Province.class);

        beansOfType.forEach((k,v) -> {
            if (v.support(flag)) {
                v.handler();
            }
        });
    }


    /**
     * 不使用设计模式，实现大量if else
     */
    @Test
    public void noDesignPattern () {

        // 省份
        String flag = "HB";
        if ("HB".equals(flag)) {

        } else if ("ZJ".equals(flag)) {

        } else if ("TJ".equals(flag)) {

        } else if ("BJ".equals(flag)) {

        } else if ("SC".equals(flag)) {

        } else if ("NMG".equals(flag)) {

        } else if ("YN".equals(flag)) {

        } else if ("FJ".equals(flag)) {

        } else if ("XJ".equals(flag)) {

        } else if ("DB".equals(flag)) {

        }
    }
}
