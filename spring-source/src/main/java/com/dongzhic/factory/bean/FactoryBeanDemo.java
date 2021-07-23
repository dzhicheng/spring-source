package com.dongzhic.factory.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

/**
 * @Author dongzhic
 * @Date 7/7/21 5:20 PM
 */
@Service
public class FactoryBeanDemo implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new FactoryB();
    }

    @Override
    public Class<?> getObjectType() {
        return FactoryB.class;
    }
}
