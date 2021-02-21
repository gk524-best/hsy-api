package com.hsy.mall.service;

import com.hsy.mall.entry.Category;
import com.hsy.mall.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public int storeCategory(Category category) {
        return categoryMapper.insert(category);
    }
}
