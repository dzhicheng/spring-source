package com.dongzhic.service.impl;

import com.dongzhic.dao.CommonMapper;
import com.dongzhic.pojo.ZgGoods;
import com.dongzhic.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    CommonMapper commonMapper;

    @Transactional
    @Override
    public void addGoods(ZgGoods zgGoods) {
        int i = commonMapper.addGood(zgGoods);
        if(true) throw new RuntimeException("yic");
    }

    @Transactional(readOnly = true)
    @Override
    public List<ZgGoods> queryAll() {
        return commonMapper.queryAll();
    }
}
