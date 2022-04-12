package com.dongzhic.test;

import com.dongzhic.bean.*;
import com.dongzhic.factory.bean.FactoryBeanDemo;
import org.apache.jasper.runtime.ExceptionUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureTask;

import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author dongzhic
 * @Date 6/26/21 11:10 AM
 */
public class MyTest {

    private Logger logger = LoggerFactory.getLogger(MyTest.class);

    private static ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

    @Autowired
    private ShowSexClass showSexClass;
    @Autowired
    private OriginClass originClass;


    @Test
    public void testThreadPoolExecutor () {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(1);
        executor.initialize();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            ListenableFuture<Boolean> asyncResult = executor.submitListenable(() -> {
               // 休息5毫秒，模拟执行
                try {
                    TimeUnit.MILLISECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return true;
            });

            asyncResult.addCallback(data -> {
                // 休息3毫秒模拟获取到执行结果后的操作
                try {
                    TimeUnit.MILLISECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, ex -> logger.info("**异常信息**：{}"));

        }
        System.out.println(String.format("总耗时：%s", System.currentTimeMillis() - start));
    }

    @Test
    public void testBean () {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanOneBean.class);
        applicationContext.getBean("student");
    }

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

//        applicationContext.setAllowBeanDefinitionOverriding(false);
//        // 允许循环依赖
//        applicationContext.setAllowCircularReferences(true);
//        applicationContext.refresh();

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
