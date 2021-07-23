package com.dongzhic.datasource;

/**
 * @Author dongzhic
 * @Date 7/18/21 5:29 PM
 */
public class DynamicDataSourceHolder  {

    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static String getDs () {
        return local.get();
    }

    public static ThreadLocal<String> getLocal () {
        return local;
    }
}

