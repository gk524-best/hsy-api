package com.hsy.manager.controller;

import com.hsy.manager.entity.User;
import com.hsy.manager.service.UserService;
import io.swagger.annotations.Api;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(tags = "登录")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestBody User user) {
        System.out.println(user.toString());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody User user) {
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        System.out.println(user.toString());
        int res = userService.storeUser(user);
        System.out.println(res);
    }
}
