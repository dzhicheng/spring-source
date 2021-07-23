package com.dongzhic.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author dongzhic
 * @Date 7/16/21 7:52 AM
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 钩子方法
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        String ds = DynamicDataSourceHolder.getDs();

        System.out.println("==============选择的数据源" + ds);
        return ds;
    }
}
