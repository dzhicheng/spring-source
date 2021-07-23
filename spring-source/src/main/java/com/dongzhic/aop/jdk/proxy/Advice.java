package com.dongzhic.aop.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author dongzhic
 * @Date 7/13/21 1:54 PM
 */
public class Advice implements InvocationHandler {

    private People people;

    public Advice(People people) {
        this.people = people;
    }

    /**
     * advice 功能增强
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 前置增强
        before();

        // 被代理方法
        Object value = method.invoke(people, args);

        // 后置增强
        after();

        return value;
    }

    public void before () {
        System.out.println("==============jack 老师准备吃饭==============");
    }

    public void after () {
        System.out.println("==============jack 老师吃完饭了==============");
    }
}
