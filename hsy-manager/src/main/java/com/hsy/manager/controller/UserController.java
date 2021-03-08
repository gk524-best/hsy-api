package com.hsy.manager.controller;

import com.hsy.common.api.ApiCode;
import com.hsy.common.api.R;
import com.hsy.manager.entity.User;
import com.hsy.manager.service.UserService;
import io.swagger.annotations.Api;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(tags = "登录")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 登陆
     * @Author zhangbingbing on 2021/2/14 下午9:47
     * @params
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public R<Object> login(@Validated @RequestBody User user) {
        User u = userService.findUserByUsername(user.getUsername());
        if (u != null && BCrypt.checkpw(user.getPassword(), u.getPassword())) {
            return R.ok();
        }
        return R.fail(ApiCode.LOGIN_ERROR);
    }

    /**
     * 账号注册
     * @Author zhangbingbing on 2021/2/14 下午9:46
     * @params
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public R<Object> register(@Validated @RequestBody User user) {
        Integer count = userService.findCountByUsername(user.getUsername());
        if (count > 0) {
            // 存在
           return R.fail(ApiCode.ACCOUNT_REGISTERED);
        } else {
            // 不存在 注册账号
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            user.setPassword(hashedPassword);
            userService.storeUser(user);
            return R.ok();
        }
    }
}
