package com.dongzhic.bean;

import org.springframework.beans.factory.DisposableBean;

import java.util.List;

/**
 * @Author dongzhic
 * @Date 6/28/21 5:54 PM
 */
public class OriginClass implements DisposableBean {

    /**
     * 这个方法需要进行业务功能增强，但是又希望在原来基础上修改，
     * 可以用replaced-method标签
     * @param param
     */
    public void method (String param) {
        System.out.println("I am origin method! param = " + param);
    }

    public void method (List<String> param) {
        System.out.println("I am origin method! param = " + param);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("==================OriginClass.DisposableBean=============================");
    }
}
