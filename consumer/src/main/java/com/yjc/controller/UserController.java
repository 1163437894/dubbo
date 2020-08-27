package com.yjc.controller;

import com.yjc.pojo.User;
import com.yjc.service.OrderService;
import com.yjc.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @DubboReference
    private UserService userService;
    @DubboReference
    private OrderService orderService;


    @RequestMapping("user")
    public User user() {
        return userService.getUser();
    }


    @RequestMapping("order")
    public User order(){
        return orderService.initOrder();
    }


}
