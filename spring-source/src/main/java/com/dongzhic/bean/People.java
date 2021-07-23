package com.dongzhic.bean;

import org.springframework.stereotype.Service;

/**
 * @Author dongzhic
 * @Date 6/28/21 5:11 PM
 */
public class People {

    private String username;

    private int age;

    public void showSex () {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
