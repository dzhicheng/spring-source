package com.dongzhic.bean;


import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author dongzhic
 * @Date 7/6/21 3:54 PM
 */
public class InitMethodBean implements InitializingBean, BeanNameAware {

    @PostConstruct
    public void postConstruct () {
        System.out.println("1.===============InitMethodBean.postConstruct()类实例化完成会调用======================");
    }

    /**
     * 类实例化完成会调用
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("2.===============InitMethodBean(InitializingBean)类实例化完成会调用======================");
    }

    /**
     * spring配置init-method
     */
    public void afterInitMethod () {
        System.out.println("3.===============InitMethodBean.afterInitMethod()类实例化完成会调用======================");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("=====================beanName: " + name);
    }
}
