package com.example.demo.controller;


import com.example.demo.entity.R;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService=userService;
    }

    @GetMapping("/login")
    public String login() {return "login";}

    @GetMapping("/chat")
    public String chat()
    {
        return "chat";
    }


    @ResponseBody
    @PostMapping("/login")
    public R<UserEntity> login(@Param("username") String username, @Param("password") String password, HttpSession session){
        return userService.login(username,password,session);
    }
    @ResponseBody
    @PostMapping("/regist")
    public R<String> regist(String username, String password){
        return userService.regist(username,password);
    }
}
