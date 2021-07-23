package com.dongzhic.test;

import com.dongzhic.bean.*;
import com.dongzhic.factory.bean.FactoryBeanDemo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * @Author dongzhic
 * @Date 6/26/21 11:10 AM
 */
public class MyTest {

    private static ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

    @Autowired
    private ShowSexClass showSexClass;
    @Autowired
    private OriginClass originClass;

    @Test
    public void replacedMethod () {
        originClass.method("xx");
        originClass.method(new ArrayList<String>());
    }

    @Test
    public void lookUpMethod () {
        showSexClass.showSex();
    }

    @Test
    public void test1 () {

        // 单元测试使用
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.dongzhic");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student.getName());

    }

    @Test
    public void test2 () {
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student.getName());

        applicationContext.setAllowBeanDefinitionOverriding(false);
        // 允许循环依赖
        applicationContext.setAllowCircularReferences(true);
        applicationContext.refresh();

    }

    @Test
    public void test3 () {

        Son son = (Son) applicationContext.getBean("son");

        System.out.println(son.getUsername());
        System.out.println(son.getAge());

    }

    @Test
    public void test4 () {

        PropertyClass propertyClass = (PropertyClass) applicationContext.getBean("propertyClass");

    }

    @Test
    public void test5 () {

//        FactoryB factoryB = (FactoryB) applicationContext.getBean("factoryBeanDemo");
//        System.out.println(factoryB);


        FactoryBeanDemo factoryBeanDemo = (FactoryBeanDemo) applicationContext.getBean("factoryBeanDemo");
        System.out.println(factoryBeanDemo);

//        FactoryBeanDemo factoryBeanDemo = (FactoryBeanDemo) applicationContext.getBean("&factoryBeanDemo");
//        System.out.println(factoryBeanDemo);


    }

    @Test
    public void prototypeTest () {
        for (int i = 0; i < 10; i++) {
            new Thread( () -> System.out.println("-------------------------------------" + applicationContext.getBean("prototypeBean"))).start();
        }
    }

    @Test
    public void circularRefPropertyTest () {
        applicationContext.getBean("circularRefPropertyA");
    }

    @Test
    public void requestSessionScopeTest () {
        applicationContext.getBean("requestSessionBean");
    }

    @Test
    public void customScopeTest () {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                if (finalI % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "-->" + applicationContext.getBean("customScopeBean"));
                    System.out.println(Thread.currentThread().getName() + "-->" + applicationContext.getBean("customScopeBean"));
                } else {
                    System.out.println(Thread.currentThread().getName() + "-->" + applicationContext.getBean("customScopeBean"));
                }
            }).start();
        }
    }

    @Test
    public void componentScanTest () {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanBean.class);
        System.out.println("componentScanTest -> " + applicationContext.getBean("userService"));
    }
}
