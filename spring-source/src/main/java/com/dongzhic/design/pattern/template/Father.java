package com.dongzhic.design.pattern.template;

/**
 * 模板模式
 *  通过子类实现钩子方法，干预父类的业务执行流程
 * @Author dongzhic
 * @Date 6/29/21 2:27 PM
 */
public abstract class Father {

    public void life (){

    }

    public void study () {
        System.out.println("=================认认真真学习==================");
    }


    public void work () {
        System.out.println("=================主动承担责任==================");
    }

    /**
     * 钩子函数，通过子类的实现干预父类的方法的业务流程
     */
    public abstract void love ();
}

class Zhangsan extends Father {

    @Override
    public void love() {
        System.out.println("================找肤白貌美大长腿==================");
    }
}

class Lisi extends Father {

    @Override
    public void love() {
        System.out.println("=================找有钱的==================");
    }
}
