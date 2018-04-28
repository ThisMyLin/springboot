package com.xiaozhai.Service.impl;

import com.xiaozhai.Mapper.GoodsMapper;
import com.xiaozhai.Pojo.Goods;
import com.xiaozhai.Service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public Goods selectByPrimaryKey(Integer goodsId) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        return goods;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 10000)
    @Override
    public void deleteByPrimaryKey(Integer goodsId) {
        goodsMapper.deleteByPrimaryKey(goodsId);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 10000)
    @Override
    public void insertGoods(Goods goods) {
        goodsMapper.insertGoods(goods);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 10000)
    @Override
    public void updateGoods(Goods goods) {
        goodsMapper.updateGoods(goods);
    }
}
