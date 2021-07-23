package com.dongzhic.bean;


import org.springframework.stereotype.Service;

/**
 * @Author dongzhic
 * @Date 6/26/21 12:47 AM
 */
//@Service
public class Student {

    private String name = "zhicheng";
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
