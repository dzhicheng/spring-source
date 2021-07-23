package com.dongzhic.design.pattern.decorator;

/**
 * @Author dongzhic
 * @Date 6/29/21 12:04 AM
 */
public class Test {

    public static void main(String[] args) {

        System.out.println("==========2001 start=================");
        House house = new JackHouse2001();
        house.people();
        house.goods();
        System.out.println("==========2001 end=================");

        System.out.println();
        System.out.println();

        System.out.println("==========2016 start=================");
        House house2016 = new Decorator2016(house);
        house2016.people();
        house2016.goods();
        System.out.println("==========2016 end=================");

        System.out.println();
        System.out.println();

        System.out.println("==========2017 start=================");
        House house2017 = new Decorator2017(house);
        house2017.people();
        house2016.goods();
        System.out.println("==========2017 end=================");
    }

}
