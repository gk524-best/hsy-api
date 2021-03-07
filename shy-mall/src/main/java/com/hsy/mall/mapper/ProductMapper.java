package com.hsy.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hsy.mall.entry.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * TODO
 * @author zhangbingbing on 2021/3/2 上午12:23
 */
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 分页查询
     * @author gk on 2021/3/5 9:48
     */
    @Select("SELECT * FROM product")
    @Results({
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "category", column = "category_id", one = @One(select = "com.hsy.mall.mapper.CategoryMapper.getCompanyById"))
    })
    IPage<Product> getProductList(IPage<Product> page);
}
