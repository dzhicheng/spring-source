package com.dongzhic.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author dongzhic
 * @Date 7/10/21 11:51 PM
 */
@Configuration
@Import(CircularRefPropertyA.class)
//@ImportResource("spring.xml")
public class ImportBean {
}
