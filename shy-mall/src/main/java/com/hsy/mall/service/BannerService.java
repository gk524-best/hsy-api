package com.hsy.mall.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hsy.mall.entry.Banner;
import com.hsy.mall.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * TODO
 *
 * @author gk on 2021/2/2517:29
 */
public class BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    /**
     * 新增banner
     * @author gk on 2021/2/25 17:31
     * @param banner {Banner}
     * @return boolean
     */
    public boolean storeBanner(Banner banner) {
        int count = bannerMapper.insert(banner);
        return count > 0;
    }

    /**
     * 更新banner
     * @author gk on 2021/2/25 17:33
     */
    public boolean updateBanner(Banner banner) {
        int count = bannerMapper.updateById(banner);
        return count > 0;
    }

    /**
     * 删除banner
     * @author gk on 2021/2/25 17:36
     */
    public boolean delBanner(int id) {
        int count = bannerMapper.deleteById(id);
        return count > 0;
    }

//    public List<Banner> QueryBannersList() {
//        QueryWrapper<Banner> wrapper = Wrappers.query();
//        wrapper.select(Banner.class);
//    }
}
