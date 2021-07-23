package com.dongzhic.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.awt.color.ProfileDataException;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author dongzhic
 * @Date 7/15/21 11:10 AM
 */
@Component
@PropertySource("classpath:config/core/core.properties")
public class DataSourceConfiguration {

    @Value("${jdbc.driverClassName}")
    private String driverClass;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String user;

    @Value("${jdbc.password}")
    private String password;

    @Resource
    Environment environment;

    /**
     * @Bean注解导致属性没有生效
     * @return
     */
    public DataSource comboPooledDataSource () {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass(environment.getProperty("jdbc.driverClassName"));
            comboPooledDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
            comboPooledDataSource.setUser(environment.getProperty("jdbc.username"));
            comboPooledDataSource.setPassword(environment.getProperty("jdbc.password"));
            comboPooledDataSource.setInitialPoolSize(10);
            comboPooledDataSource.setMinPoolSize(10);
            comboPooledDataSource.setMaxPoolSize(100);
            comboPooledDataSource.setMaxIdleTime(1800);
            comboPooledDataSource.setAcquireIncrement(3);
            comboPooledDataSource.setMaxStatements(1000);
            comboPooledDataSource.setIdleConnectionTestPeriod(60);
            comboPooledDataSource.setAcquireIncrement(30);
            comboPooledDataSource.setBreakAfterAcquireFailure(false);
            comboPooledDataSource.setTestConnectionOnCheckout(false);
            comboPooledDataSource.setAcquireRetryDelay(100);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        return comboPooledDataSource;
    }

    @Bean
    public DataSource dynamicDataSource () {

        ComboPooledDataSource comboPooledDataSource = (ComboPooledDataSource) comboPooledDataSource();

        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("ds1" , comboPooledDataSource);

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(comboPooledDataSource);
        return dynamicDataSource;
    }
}
