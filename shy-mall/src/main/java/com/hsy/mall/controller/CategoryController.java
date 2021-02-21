package com.hsy.mall.controller;

import com.hsy.mall.entry.Category;
import com.hsy.mall.service.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品分类
 * @author gk
 * @date 2021/2/21 16:51
 */
@Api(tags = "商品")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/mall/category/add", method = RequestMethod.POST)
    public void storeMallCategory(@Validated @RequestBody Category category) {
        int count = categoryService.storeCategory(category);
        System.out.println(count);
    }
}
