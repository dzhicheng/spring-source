package com.dongzhic.aop.intercepter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @Author dongzhic
 * @Date 7/14/21 10:01 AM
 */
@Component
public class CostomInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println("===========全局拦截===========");
        return invocation.proceed();
    }
}
