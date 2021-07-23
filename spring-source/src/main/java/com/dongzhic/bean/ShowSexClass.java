package com.dongzhic.bean;

import org.springframework.beans.factory.annotation.Lookup;

/**
 * @Author dongzhic
 * @Date 6/28/21 5:09 PM
 */
public abstract class ShowSexClass {

    public void showSex () {
        getPeople().showSex();
    }

    /**
     * 不一定是抽象方法
     * @return
     */
//    @Lookup("woman")
    public abstract People getPeople ();

}
