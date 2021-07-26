package com.dongzhic.aop.aspectj;

import com.dongzhic.annotation.TargetSource;
import com.dongzhic.datasource.DynamicDataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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

    @Around(value = "@annotation(targetSource)",argNames = "joinPoint,targetSource")
    public void xx(ProceedingJoinPoint joinPoint, TargetSource targetSource) {

        System.out.println("========AspectDs.xx");
        String value = targetSource.value();

        if (value != null && !"".equals(value)) {
            DynamicDataSourceHolder.getLocal().set(value);
        } else {
            DynamicDataSourceHolder.getLocal().set("ds1");
        }
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}