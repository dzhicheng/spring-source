package com.dongzhic.bean.post.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Service;

/**
 * 使spring @Autowired无法依赖注入
 *  AbstractAutowireCapableBeanFactory.populateBean()
 * @Author dongzhic
 * @Date 7/5/21 9:05 PM
 */
@Service
public class InstantiationAwareBeanPostProcessorDemo implements InstantiationAwareBeanPostProcessor {

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return false;
    }
}
