package com.dongzhic.transaction;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * 注解方式引入事务
 * 替代spring-tx.xml配置
 * @Author dongzhic
 * @Date 7/15/21 7:52 AM
 */
@Component
@EnableTransactionManagement
@MapperScan(basePackages = {"com.dongzhic.dao"}, annotationClass = Repository.class)
public class EnableTransactionManagementBean {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public TransactionTemplate transactionTemplate (PlatformTransactionManager platformTransactionManager) {

        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(platformTransactionManager);

        return transactionTemplate;
    }

}
