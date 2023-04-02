package com.example.demo.config;

import com.example.demo.controller.UserController;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.service.serviceImpl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class appConfig {
    @Bean
    public UserService userService()
    {
        return new UserServiceImpl();
    }
}
