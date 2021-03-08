package com.hsy.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hsy.mall.entry.Category;

import java.util.Map;

public interface CategoryMapper extends BaseMapper<Category> {
    // 获取分类
    Map<String, Object> getCategoryById(Integer id);
}
