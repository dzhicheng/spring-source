package com.dongzhic.aop.jdk.proxy;

/**
 * @Author dongzhic
 * @Date 7/13/21 1:47 PM
 */
public class Jack implements People {

    /**
     * joinpoint 连接点
     * @param param
     * @return
     */
    @Override
    public String eat(String param) {
        String result = "==============jack 老师喜欢吃东西==============";
        System.out.println(result);
        return result;
    }
}
