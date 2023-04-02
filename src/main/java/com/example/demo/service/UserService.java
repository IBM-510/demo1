package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.R;
import com.example.demo.entity.UserEntity;
import org.springframework.context.annotation.Bean;
import javax.servlet.http.HttpSession;

public interface UserService extends IService<UserEntity> {
    public R<UserEntity> login(String username, String password, HttpSession httpSession);
    public R<String> regist(String username, String password);
}
