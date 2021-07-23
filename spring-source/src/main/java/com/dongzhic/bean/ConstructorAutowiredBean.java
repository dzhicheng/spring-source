package com.dongzhic.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author dongzhic
 * @Date 7/3/21 5:59 PM
 */
@Data
@Service
public class ConstructorAutowiredBean {

    @Autowired
    private Student student;

    @Autowired
    private PropertyBean propertyBean;

    @PostConstruct
    private void postConstruct () {
        System.out.println("====================ConstructorAutowiredBean.postConstruct=============================");
    }

    @PreDestroy
    public void preDestroy () {
        System.out.println("====================ConstructorAutowiredBean.preDestroy=============================");
    }

    /**
     * @Autowired目的：
     *  把spring容器中student的实例，
     *  以入参的方式注入到构造函数中
     * @param student
     */
//    @Autowired
//    public ConstructorAutowiredBean(Student student) {
//        this.student = student;
//    }
}
