package com.dongzhic.design.pattern.decorator;

/**
 * @Author dongzhic
 * @Date 6/28/21 11:49 PM
 */
public class Decorator2016 extends Decorator{

    public Decorator2016 (House house) {
        super(house);
    }

    public void findWife () {
        JackHouse2001 jackHouse2001 = (JackHouse2001) house;
        jackHouse2001.getPeoples().add("老婆");
        System.out.println("===========2016年 jack 取到老婆=====");
    }

    @Override
    public void people() {
        super.people();
        findWife();
    }

    public void addGoods () {
        JackHouse2001 jackHouse2001 = (JackHouse2001) house;
        jackHouse2001.getGoods().add("电视机");
        jackHouse2001.getGoods().add("冰箱");
        System.out.println("===========2016年 买了冰箱、电视机=====");
    }


    @Override
    public void goods() {
        super.goods();
        addGoods();
    }
}
