package com.dongzhic.aop.aspectj;

import com.dongzhic.annotation.TargetSource;
import com.dongzhic.datasource.DynamicDataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author dongzhic
 * @Date 7/13/21 7:47 AM
 */
@Component
@Aspect
@Order(-1)
public class AspectDs {

    @Before(value = "@annotation(targetMethod)", argNames = "joinPoint, targetSource")
    public void xx (JoinPoint joinPoint, TargetSource targetSource) {

        String value = targetSource.value();

        if (value != null && !"".equals(value)) {
            DynamicDataSourceHolder.getLocal().set(value);
        } else {
            DynamicDataSourceHolder.getLocal().set("ds1");
        }
    }

}
