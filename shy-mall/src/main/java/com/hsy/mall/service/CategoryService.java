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

    /**
    　* 新增商品分类
    　* @author gk on 2021/2/25 上午12:16
    　* @param category 实体类
    　* @return ${return_type}
    　*/
    public void storeCategory(Category category) {
        categoryMapper.insert(category);
    }

    /**
     * 查询类型名是否重复
     * @Author gk on 2021/2/24 下午10:41
     * @param categoryName 类型名称
     * @return Boolean
     */
    public boolean checkCategoryNameRepeat(String categoryName) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("category_name", categoryName);
        Integer count  = categoryMapper.selectCount(wrapper);
        return count > 0;
    }

    /**
    　* 根据id查询单条数据
    　* @author gk on 2021/2/25 上午12:04
    　* @param id 自增ID
    　* @return Category
    　*/
    public Category getCategoryById(Integer id) {
        return categoryMapper.selectById(id);
    }

    /**
    　* 递归删除
    　* @author gk
    　* @date 2021/2/24 下午10:55
    　* @param ${tags}
    　* @return ${return_type}
    　*/
    public boolean delCategoryById(Integer id) {
        ArrayList<Integer> ids = new ArrayList<>();
        // 删除的父级id先放进集合中
        ids.add(id);
        // 递归所有子类id
        this.getIds(ids, id);
        int count = categoryMapper.deleteBatchIds(ids);
        return count > 0;
    }

    /**
     * 递归获取子类ids
     * @Author gk on 2021/2/24 下午10:44
     * @param ids 父类id集合
     * @param id  父类id
     * @return void
     */
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
