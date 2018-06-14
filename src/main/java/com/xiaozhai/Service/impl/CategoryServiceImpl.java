package com.xiaozhai.Service.impl;

import com.xiaozhai.Mapper.CategoryMapper;
import com.xiaozhai.Pojo.Category;
import com.xiaozhai.Service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

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
        return categoryMapper.selectByPrimaryKey(categoryId);
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
