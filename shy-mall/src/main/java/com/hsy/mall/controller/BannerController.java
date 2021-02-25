package com.hsy.mall.controller;

import com.hsy.common.api.ApiCode;
import com.hsy.common.api.R;
import com.hsy.common.utils.ValidationGroup;
import com.hsy.mall.entry.Banner;
import com.hsy.mall.service.BannerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO
 *
 * @author gk on 2021/2/2517:45
 */
public class BannerController {
    private BannerService bannerService;

    /**
     * 新增banner
     * @author gk on 2021/2/25 17:49
     */
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
    @RequestMapping(value = "/banner/update", method = RequestMethod.POST)
    public R<Object> updateBanner(@Validated(ValidationGroup.Update.class) Banner banner) {
        if (banner.getSort() == null) {
            banner.setSort(0);
        }
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
    @RequestMapping(value = "/banner/delete/:id", method = RequestMethod.DELETE)
    public R<Object> delBanner(@PathVariable int id) {
        boolean state = bannerService.delBanner(id);
        if (state) {
            return R.ok();
        } else {
            return R.fail(ApiCode.OPERATION_FAILED);
        }
    }
}
