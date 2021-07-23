package com.dongzhic.bean;

/**
 * @Author dongzhic
 * @Date 6/28/21 4:57 PM
 */
public class FactoryBean {

    public PropertyClass factoryMethod () {

        System.out.println("=================factoryMethod=================");

        return new PropertyClass();
    }
}
