package com.yjc.controller;

import com.yjc.pojo.User;
import com.yjc.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @DubboReference(loadbalance = "roundrobin")
    private UserService userService;


    @RequestMapping("user")
    public User user() {
        return userService.getUser();
    }
}
