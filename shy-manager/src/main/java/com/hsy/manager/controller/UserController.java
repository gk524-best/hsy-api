package com.hsy.manager.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "登录")
@RestController
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login() {

    }
}
