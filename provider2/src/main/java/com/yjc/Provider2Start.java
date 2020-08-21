package com.yjc;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class Provider2Start {
    public static void main(String[] args) {
        SpringApplication.run(Provider2Start.class,args);
    }
}
