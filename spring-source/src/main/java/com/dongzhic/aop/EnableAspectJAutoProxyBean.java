package com.dongzhic.aop;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

/**
 * @Service 会被@ComponentScan扫描到
 * @EnableAspectJAutoProxy 开启注解AOP
 *      替代了：<aop:aspectj-autoproxy />
 *  exposeProxy：是否要暴露代理对象
 *
 * @Author dongzhic
 * @Date 7/13/21 7:36 AM
 */
@Service
@EnableAspectJAutoProxy(exposeProxy = true)
public class EnableAspectJAutoProxyBean {
}
