package com.xiaozhai.test01.Mapper;

import com.xiaozhai.Pojo.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Category2Mapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}