package com.yjc.impl;

import com.yjc.pojo.User;
import com.yjc.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@DubboService
@Component
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        User user= new User();
        user.setAge(1);
        user.setName("yjc");
        return user;
    }
}
