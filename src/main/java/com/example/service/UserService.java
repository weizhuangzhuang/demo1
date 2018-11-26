package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author ChainSmoker
 * @Date 2018/11/26/026 10:04
 * @VERSION 1.0
 **/

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    public User sel(int id){
        return userMapper.sel(id);
    }

    public User login(String userName, String passWord) {
        return userMapper.login(userName,passWord);
    }

    public int register(User user) {
        return userMapper.register(user);
    }
}
