package com.dongzhic.test;

import com.dongzhic.bean.ComponentScanBean;
import com.dongzhic.service.AccountService;
import com.dongzhic.service.AreaService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author dongzhic
 * @Date 7/15/21 12:05 PM
 */
public class TransactionTest {

    ApplicationContext applicationContext;

    @Before
    public void before () {
        applicationContext = new AnnotationConfigApplicationContext(ComponentScanBean.class);
    }

    @Test
    public void test1 () {
        AreaService bean = applicationContext.getBean(AreaService.class);
        Map<String, Object> param = new HashMap<>();
        param.put("areaCode", "HB1");
        bean.queryAreaFromDB(param);
    }

    @Test
    public void accountServiceTestt () {
        AccountService bean = applicationContext.getBean(AccountService.class);
        bean.queryAccount("d");
    }
}
