package com.yjc.controller;

import com.yjc.pojo.User;
import com.yjc.service.OrderService;
import com.yjc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户接口")
public class UserController {
    @DubboReference
    private UserService userService;
    @DubboReference
    private OrderService orderService;


    @GetMapping("user")
    @ApiOperation("用户")
    public User user() {
        return userService.getUser();
    }


    @GetMapping("order")
    @ApiOperation("订单")
    public User order(){
        return orderService.initOrder();
    }


}
