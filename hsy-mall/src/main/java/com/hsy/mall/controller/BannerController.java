package com.hsy.mall.controller;

import com.hsy.common.api.ApiCode;
import com.hsy.common.api.R;
import com.hsy.common.utils.PageBase;
import com.hsy.mall.entry.Banner;
import com.hsy.mall.service.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author gk on 2021/2/2517:45
 */
@Api(tags = "首页banner")
@RestController
public class BannerController {

    @Autowired
    private BannerService bannerService;

    /**
     * 新增banner
     * @author gk on 2021/2/25 17:49
     */
    @ApiOperation(value = "添加banner")
    @RequestMapping(value = "/banner/add", method = RequestMethod.POST)
    public R<Object> storeBanner(@Validated Banner banner) {
        if (banner.getSort() == null) {
            banner.setSort(0);
        }
        boolean storeState = bannerService.storeBanner(banner);
        if (storeState) {
            return R.ok();
        } else {
            return R.fail(ApiCode.OPERATION_FAILED);
        }
    }

    /**
     * 更新banner
     * @author gk on 2021/2/25 17:52
     */
    @ApiOperation(value = "更新banner")
    @RequestMapping(value = "/banner/update/{id}", method = RequestMethod.PUT)
    public R<Object> updateBanner(@Validated @PathVariable int id, Banner banner) {
        if (banner.getSort() == null) {
            banner.setSort(0);
        }
        banner.setId(id);
        boolean state = bannerService.updateBanner(banner);
        if (state) {
            return R.ok();
        } else {
            return R.fail(ApiCode.OPERATION_FAILED);
        }
    }

    /**
     * 删除banner
     * @author gk on 2021/2/25 17:54
     */
    @ApiOperation(value = "删除banner")
    @RequestMapping(value = "/banner/delete/{id}", method = RequestMethod.DELETE)
    public R<Object> delBanner(@PathVariable int id) {
        boolean state = bannerService.delBanner(id);
        if (state) {
            return R.ok();
        } else {
            return R.fail(ApiCode.OPERATION_FAILED);
        }
    }

    @ApiOperation(value = "banner列表")
    @RequestMapping(value = "/banner/query", method = RequestMethod.GET)
    public R<Object> queryList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageBase<Banner> pageBase = bannerService.queryBannersList(page, size);
        return R.ok(pageBase);
    }
}
