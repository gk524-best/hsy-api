package com.hsy.mall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hsy.common.utils.PageBase;
import com.hsy.mall.entry.Product;
import com.hsy.mall.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author gk on 2021/3/2 18:54
 */
@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 新增一个商品
     * @author gk on 2021/3/2 18:57
     * @param product 商品
     * @return boolean
     */
    public boolean storeProduct(Product product) {
        int count = productMapper.insert(product);
        return count > 0;
    }

    /**
     * 编辑商品
     * @author gk on 2021/3/2 19:33
     */
    public boolean editProduct(Product product) {
       int count = productMapper.updateById(product);
        return count > 0;
    }

    /**
     * 删除一个商品
     * @author gk on 2021/3/2 19:27
     * @param id 商品ID
     * @return boolean
     */
    public boolean delProduct(int id) {
        int count = productMapper.deleteById(id);
        return count > 0;
    }

    /**
    　*
    　* @author gk on 2021/3/2 下午10:11
    　* @param current 当前页
    　* @param size    每页数量
    　* @return ${return_type}
    　*/
    public PageBase<Product> queryProducts(Integer current, Integer size) {
        PageBase<Product> pageBase = new PageBase<>();
        IPage<Product> page = new Page<>(current, size);
        productMapper.getProductList(page);
        System.out.println(page);

//        productMapper.selectPage(page, null);
        pageBase.setTotal(page.getTotal());
        pageBase.setRows(page.getRecords());
        return pageBase;
    }
}
