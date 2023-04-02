package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("lab_user")
public class UserEntity {

    @TableId
    private String id;
    private String username;
    private String password;
    private Date lastLoginTime;
}
