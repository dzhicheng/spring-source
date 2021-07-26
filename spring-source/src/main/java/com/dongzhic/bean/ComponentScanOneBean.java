package com.dongzhic.bean;

import com.dongzhic.datasource.DataSourceConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author dongzhic
 * @Date 7/10/21 10:58 AM
 */
@Component
@ComponentScan(basePackageClasses = DataSourceConfiguration.class)
public class ComponentScanOneBean {
}
