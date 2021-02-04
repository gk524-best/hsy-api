package com.hsy.manager.controller;

import com.hsy.manager.entity.User;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = "登录")
@RestController
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestBody User user) {
        System.out.println(user.toString());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody User user) {

    }
}
