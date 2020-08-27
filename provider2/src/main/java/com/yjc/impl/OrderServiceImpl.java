package com.yjc.impl;

import com.yjc.pojo.User;
import com.yjc.service.OrderService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(interfaceClass = OrderService.class)
public class OrderServiceImpl implements OrderService {


    @Override
    public User initOrder() {
        System.out.println("进入order");
//        throw new  RuntimeException("123");
        User user = new User();
        user.setName("yjc order user");
        user.setAge(2);
        return user;

    }
}
