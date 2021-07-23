package com.dongzhic.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 多例是懒加载
 * @Author dongzhic
 * @Date 7/9/21 10:31 PM
 */
@Data
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CircularRefPropertyB {

    @Autowired
    private CircularRefPropertyA circularRefPropertyA;

}
