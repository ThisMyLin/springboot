package com.xiaozhai.Service.impl;

import com.xiaozhai.Mapper.CategoryMapper;
import com.xiaozhai.Pojo.Category;
import com.xiaozhai.Service.CategoryService;
import com.xiaozhai.test01.Mapper.Category2Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private Category2Mapper category2Mapper;

    @Override
    public int deleteByPrimaryKey(Integer categoryId) {
        return 0;
    }

    @Transactional
    @Override
    public int insert(Category record) {
        int result = categoryMapper.insert(record);
        Category category02 = new Category();
        category02.setAppImage("");
        category02.setCategoryName("test2");
        category02.setCategoryNameEnglish("test2English");
        category02.setCategoryNameMian("test2Mian");
        category02.setCategorySort(1);
        category02.setDeep(1);
        category02.setIsPush(true);
        category02.setParentId(1);
        category2Mapper.insert(category02);
        return result;
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
