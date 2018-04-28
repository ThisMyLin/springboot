package com.xiaozhai.Mapper;

import com.xiaozhai.Pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GoodsMapper {

    Goods selectByPrimaryKey(@Param("goodsId") Integer goodsId);

    void deleteByPrimaryKey(@Param("goodsId") Integer goodsId);

    void insertGoods(Goods goods);

    void updateGoods(Goods goods);
}
