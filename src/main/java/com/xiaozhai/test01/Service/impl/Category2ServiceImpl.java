package com.xiaozhai.test01.Service.impl;

import com.xiaozhai.Pojo.Category;
import com.xiaozhai.test01.Mapper.Category2Mapper;
import com.xiaozhai.test01.Service.Category2Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Category2ServiceImpl implements Category2Service {

    @Resource
    private Category2Mapper category2Mapper;

    @Override
    public int deleteByPrimaryKey(Integer categoryId) {
        return 0;
    }

    @Override
    public int insert(Category record) {
        return 0;
    }

    @Override
    public int insertSelective(Category record) {
        return 0;
    }

    @Override
    public Category selectByPrimaryKey(Integer categoryId) {
        return category2Mapper.selectByPrimaryKey(categoryId);
    }

    @Override
    public int updateByPrimaryKeySelective(Category record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        return 0;
    }
}
