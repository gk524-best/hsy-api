package com.hsy.mall.controller;

import com.hsy.common.api.ApiCode;
import com.hsy.common.api.R;
import com.hsy.mall.entry.Product;
import com.hsy.mall.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * TODO
 * @author zhangbingbing on 2021/3/2 上午12:44
 */
@Api(tags = "商品")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 新增商品
     * @author gk on 2021/3/2 19:08
     */
    @ApiOperation(value = "新增商品")
    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public R<Object> storeProduct(@Validated Product product) {
        product.setCreateTime(new Date());
        product.setUpdateTime(new Date());
        boolean state = productService.storeProduct(product);
        if (state) {
            return R.ok();
        } else {
            return R.fail(ApiCode.OPERATION_FAILED);
        }
    }

    /**
     * 编辑商品
     * @author gk on 2021/3/2 19:33
     */
    @ApiOperation(value = "编辑商品")
    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public R<Object> editProduct(@Validated int id, Product product) {
        product.setUpdateTime(new Date());
        product.setId(id);
        boolean state = productService.editProduct(product);
        if (state) {
            return R.ok();
        } else {
            return R.fail(ApiCode.OPERATION_FAILED);
        }
    }

    /**
     * 删除商品
     * @author gk on 2021/3/2 19:28
     */
    @ApiOperation(value = "删除商品")
    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public R<Object> delProduct(@PathVariable int id) {
        boolean state = productService.delProduct(id);
        if (state) {
            return R.ok();
        } else {
            return R.fail(ApiCode.OPERATION_FAILED);
        }
    }
}
