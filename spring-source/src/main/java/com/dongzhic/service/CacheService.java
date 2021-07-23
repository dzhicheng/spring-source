package com.dongzhic.service;

public interface CacheService {

    String queryData(String id);

    String putCache(String id);

    String getCache(String id);

    String mapCache(String id);
}
