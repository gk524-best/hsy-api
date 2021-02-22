package com.hsy.mall.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hsy.mall.entry.Category;
import com.hsy.mall.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public int storeCategory(Category category) {
        return categoryMapper.insert(category);
    }

    public boolean delCategoryById(Integer id) {
        ArrayList<Integer> ids = new ArrayList<>();
        // 删除的父级id先放进集合中
        ids.add(id);
        // 递归所有子类id
        this.getIds(ids, id);
        int count = categoryMapper.deleteBatchIds(ids);
        return count > 0;
    }

    public void getIds(ArrayList<Integer> ids, Integer id) {
        // 查询二级分类
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        // p_id查询子类
        wrapper.eq("p_id", id);
        List<Category> list = categoryMapper.selectList(wrapper);
        // 递归遍历
        for (Category category:list) {
            Integer listId = category.getId();
            ids.add(listId);
            getIds(ids, listId);
        }
    }
}
