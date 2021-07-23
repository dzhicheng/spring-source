package com.dongzhic.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * @Author dongzhic
 * @Date 7/10/21 12:02 AM
 */
public class CustomScope implements Scope {

    /**
     * 同一线程下，为同一实例
     */
    private ThreadLocal local = new ThreadLocal();


    /**
     * 自己管理自己的bean
     * @param name
     * @param objectFactory
     * @return
     */
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        System.out.println("==================CustomScope=======================");
        if (local.get() != null) {
            return local.get();
        } else {
            // 调createBean方法获得一个实例
            Object object = objectFactory.getObject();
            local.set(object);
            return object;
        }
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
