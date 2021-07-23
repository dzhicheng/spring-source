package com.dongzhic.bean;

/**
 * @Author dongzhic
 * @Date 6/28/21 10:22 PM
 */
public class ConstructorArgBean {

    private String username;

    private String password;

    ConstructorArgBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "ConstructorArgBean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
