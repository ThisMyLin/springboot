package com.xiaozhai.Service;


import com.xiaozhai.Pojo.Goods;

public interface GoodsService {

    /**
     * 查
     * @param goodsId
     * @return
     */
    Goods selectByPrimaryKey(Integer goodsId);

    /**
     * 删
     * @param goodsId
     */
    void deleteByPrimaryKey(Integer goodsId);

    /**
     * 增
     * @param goods
     */
    void insertGoods(Goods goods);

    /**
     * 改
     * @param goods
     */
    void updateGoods(Goods goods);
}
