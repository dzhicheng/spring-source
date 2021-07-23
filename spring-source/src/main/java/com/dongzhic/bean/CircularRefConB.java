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
public class CircularRefConB {

    /**
     * 启动报错：只有单例下才能循环依赖
     * @param circularRefConA
     */
//    @Autowired
//    public CircularRefConB(CircularRefConA circularRefConA) {
//        System.out.println("===============CircularRefConB()======================");
//    }
}
