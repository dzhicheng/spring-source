package com.dongzhic.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 循环依赖
 * @Author dongzhic
 * @Date 7/6/21 5:33 PM
 */
@Data
@Service
public class CircularRefB {

    @Autowired
    private CircularRefA circularRefA;

    public CircularRefB() {
        System.out.println("===============CircularRefB()======================");
    }


}
