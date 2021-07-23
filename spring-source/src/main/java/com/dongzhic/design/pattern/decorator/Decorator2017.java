package com.dongzhic.design.pattern.decorator;

/**
 * @Author dongzhic
 * @Date 6/29/21 12:00 AM
 */
public class Decorator2017 extends Decorator2016 {

    public Decorator2017(House house) {
        super(house);
    }

    public void hasBaby () {
        JackHouse2001 jackHouse2001 = (JackHouse2001) house;
        jackHouse2001.getPeoples().add("baby");
        System.out.println("============2017 jac有了一个baby===========");
    }

    @Override
    public void people() {
        super.people();
        hasBaby();
    }

    public void addKongTiao () {
        JackHouse2001 jackHouse2001 = (JackHouse2001) house;
        jackHouse2001.getGoods().add("空调");
        System.out.println("============2017装了空调=================");
    }

    @Override
    public void goods() {
        super.goods();
        addKongTiao();
    }


}
