package com.dongzhic.service.impl;

import com.dongzhic.annotation.ReturnValue;
import com.dongzhic.annotation.TargetMethod;
import com.dongzhic.annotation.ThrowsAnno;
import com.dongzhic.service.BankService;

import java.util.List;

/**
 * @Author dongzhic
 * @Date 7/14/21 3:27 PM
 */
public class BankServiceImpl implements BankService {


    @Override
    public String queryBank(String bankId, int id, List list) {
        return null;
    }

    @TargetMethod(name = "queryArea")
    @Override
    public void queryArea(String areaId) {
        System.out.println("=================BankServiceImpl.queryArea");
    }

    @ReturnValue(name = "returnValue")
    @Override
    public Object returnValue(String id) {
        return "=================演示返回结果=================";
    }

    @ThrowsAnno(name = "throwMethod")
    @Override
    public void throwMethod(String id) {
        System.out.println("================获取异常演示================");
        throw new RuntimeException("==异常==");

    }
}
