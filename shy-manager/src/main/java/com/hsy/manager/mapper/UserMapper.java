package com.hsy.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hsy.manager.entity.User;

/**
 * @Description:
 * @Author: gk
 * @Date: Created in 2021/2/4 18:45
 */
public interface UserMapper extends BaseMapper<User> {
    int insert(User user);
}
