package com.dongzhic.bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

/**
 * @Author dongzhic
 * @Date 7/10/21 10:58 AM
 */
@Service
@ComponentScan(basePackages = {"com.dongzhic"})
//@Import(OriginClass.class)
public class  ComponentScanBean {
}
