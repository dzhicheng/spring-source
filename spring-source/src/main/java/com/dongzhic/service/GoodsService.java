package com.dongzhic.service;

import com.dongzhic.pojo.ZgGoods;

import java.util.List;

public interface GoodsService {

    void addGoods(ZgGoods zgGoods);

    List<ZgGoods> queryAll();
}
