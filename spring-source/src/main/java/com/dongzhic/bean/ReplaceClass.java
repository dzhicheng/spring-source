package com.dongzhic.bean;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @Author dongzhic
 * @Date 6/28/21 5:54 PM
 */
public class ReplaceClass implements MethodReplacer {

    /**
     * 再实现
     * @param obj
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {

        System.out.println("I am replace method --> reimplement");
        return null;
    }
}
