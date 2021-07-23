package com.dongzhic.aop.jdk.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author dongzhic
 * @Date 7/13/21 1:57 PM
 */
public class MyTest {

    public static void main(String[] args) {

        People proxy = (People) Proxy.newProxyInstance(MyTest.class.getClassLoader(), new Class<?>[]{People.class},
                    new Advice(new Jack()));
        proxy.eat("chi");

    }

}
