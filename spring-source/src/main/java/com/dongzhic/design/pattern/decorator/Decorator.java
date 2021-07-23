package com.dongzhic.design.pattern.decorator;

/**
 * 装饰者类
 *  是对房子的装饰，需要实现House接口
 *
 *  装饰着规定了装饰流程：规定了接口调用过程，具体子类实例方法如何调用子类去实现
 * @Author dongzhic
 * @Date 6/28/21 11:41 PM
 */
public class Decorator implements House {

    /**
     * 被装饰对象
     */
    public House house;

    public Decorator(House house) {
        this.house = house;
    }

    @Override
    public void people() {
        house.people();
    }

    @Override
    public void goods() {
        house.goods();
    }
}
