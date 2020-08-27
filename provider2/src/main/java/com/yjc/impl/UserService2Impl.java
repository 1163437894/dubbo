package com.yjc.impl;


import com.yjc.pojo.User;
import com.yjc.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class UserService2Impl implements UserService {

    @Override
    public User getUser() {
        User user = new User();
        user.setName("user2");
        user.setAge(1);
        return user;
    }
}
