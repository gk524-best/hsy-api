package com.hsy.mall.controller;

import com.github.pagehelper.util.StringUtil;
import com.hsy.common.api.ApiCode;
import com.hsy.common.api.R;
import com.hsy.mall.entry.Category;
import com.hsy.mall.service.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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

    /**
    　* 商品分类添加
    　* @author gk on 2021/2/24 下午11:34
    　*/
    @RequestMapping(value = "/category/add", method = RequestMethod.POST)
    public R<Object> storeMallCategory(@Validated @RequestBody Category category) {
        category.setCreateTime(new Date());
        category.setUpdateTime(new Date());
        category.setSort(0);
        if (category.getPid() == null) {
            category.setCategoryLevel(0);
        } else {
            Category cg = categoryService.getCategoryById(category.getPid());
            category.setCategoryLevel(cg.getCategoryLevel() + 1);
        }
        boolean isRepeat = categoryService.checkCategoryNameRepeat(category.getCategoryName());
        if (isRepeat) {
            return R.fail(ApiCode.DATE_REPEAT, "商品名称不能重复！");
        } else {
            categoryService.storeCategory(category);
            return R.ok();
        }
    }



    /**
     * 商品分类删除
     * @author gk
     * @date 2021/2/22 19:30
     */
    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public R<Object> removeCategoryById(@PathVariable Integer id) {
        boolean delStatus = categoryService.delCategoryById(id);
        if (delStatus) {
            return R.ok();
        }
        return R.fail(ApiCode.OPERATION_FAILED);
    }
}
