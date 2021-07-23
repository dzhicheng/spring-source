package com.dongzhic.test;

import com.dongzhic.bean.ComponentScanBean;
import com.dongzhic.service.BankService;
import com.dongzhic.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author dongzhic
 * @Date 7/13/21 7:58 AM
 */
public class AopTest {

    @Autowired
    private UserService userService;

    private ApplicationContext applicationContext;

    @Before
    public void before () {
        applicationContext = new AnnotationConfigApplicationContext(ComponentScanBean.class);
    }

    @Test
    public void test1 () {
        UserService userService = applicationContext.getBean(UserService.class);
        // userService是代理实例，调用JdkDynamicAopProxy.invoke()方法
        userService.queryUser("jack");
    }

    public void test2 () {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("sprig.xml");
        applicationContext.getBean("student");
    }

    public void annoIntercepoter () {
        BankService bean = applicationContext.getBean(BankService.class);
        bean.queryArea("jack");
        bean.returnValue("jack");
        bean.throwMethod("jack");
    }

}
