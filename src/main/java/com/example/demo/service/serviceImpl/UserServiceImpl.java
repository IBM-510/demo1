package com.example.demo.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.demo.entity.R;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    @Override
    public R<UserEntity> login(String username, String password, HttpSession httpSession) {
        if(username==null) return R.error("请输入账号");
        LambdaQueryWrapper<UserEntity> qw=new LambdaQueryWrapper<>();
        qw.eq(Strings.isNotEmpty(username),UserEntity::getUsername,username);
        UserEntity user = this.getOne(qw);
        if(user==null) return R.error("无该用户，请先注册");
        if(password.equals("")) return R.error("密码不能为空");
        if (password.equals(user.getPassword())) {
            httpSession.setAttribute("username",user.getUsername());
            user.setLastLoginTime(new Date());
            this.updateById(user);
            return R.success(user);
        }
        return R.error("密码错误");
    }

    @Override
    public R<String> regist(String username, String password) {
        LambdaQueryWrapper<UserEntity> qw=new LambdaQueryWrapper<>();
        qw.eq(Strings.isNotEmpty(username),UserEntity::getUsername,username);
        UserEntity user = this.getOne(qw);
        if(user!=null) return R.error("用户名已存在，请改变用户名");
        UserEntity userEntity=new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        this.save(userEntity);
        return R.success("注册成功");
    }
}
