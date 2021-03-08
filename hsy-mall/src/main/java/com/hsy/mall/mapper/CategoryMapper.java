package com.hsy.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hsy.mall.entry.Category;
import com.hsy.mall.entry.vo.CategoryVo;

public interface CategoryMapper extends BaseMapper<Category> {
    // 获取分类
    CategoryVo getCategoryById(long id);
}
