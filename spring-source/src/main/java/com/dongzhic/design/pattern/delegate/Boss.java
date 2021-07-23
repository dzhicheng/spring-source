package com.dongzhic.design.pattern.delegate;

/**
 * 委托模式
 *  两个对象参与处理同一请求，接收请求的对象将委托另一个对象来处理。
 * @Author dongzhic
 * @Date 6/29/21 2:39 PM
 */
public class Boss implements Company {

    private Sun sun = new Sun();

    @Override
    public void product() {
        sun.product();
    }
}

interface Company {
    void product();
}

class Sun implements Company {

    @Override
    public void product() {
        System.out.println("sun product");
    }
}


