package com.hsy.manager.service;

import com.hsy.manager.entity.User;
import com.hsy.manager.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: gk
 * @Date: Created in 2021/2/5 9:54
 */
@Service
public class UserService {

    @Autowired(required = false)
    UserMapper userMapper;

    public int storeUser(User user) {
        return userMapper.insert(user);
    }
}
