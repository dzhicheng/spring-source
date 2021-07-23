package com.dongzhic.design.pattern.decorator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dongzhic
 * @Date 6/28/21 11:27 PM
 */
public class JackHouse2001 implements House {

    private List<String> peoples = new ArrayList<>();

    private List<String> goods = new ArrayList<>();


    @Override
    public void people() {
        peoples.add("老爸");
        peoples.add("老妈");
        peoples.add("弟弟");
        peoples.add("我");

        System.out.println("=========2001年Jack 人员4名============");
    }

    @Override
    public void goods() {
        goods.add("手电筒");

        System.out.println("============2001年jack 有一个手电筒=================");

    }

    public List<String> getPeoples() {
        return peoples;
    }

    public void setPeoples(List<String> peoples) {
        this.peoples = peoples;
    }

    public List<String> getGoods() {
        return goods;
    }

    public void setGoods(List<String> goods) {
        this.goods = goods;
    }
}
