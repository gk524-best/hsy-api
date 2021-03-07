package com.hsy.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hsy.mall.entry.Category;
import com.hsy.mall.entry.vo.CategoryVo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface CategoryMapper extends BaseMapper<Category> {

    @Select("SELECT id, category_name FROM category WHERE id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "category_name")
    })
    CategoryVo getCompanyById(long id);

}
