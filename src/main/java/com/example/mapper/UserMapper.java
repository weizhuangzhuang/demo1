package com.example.mapper;

import com.example.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author ChainSmoker
 * @Date 2018/11/26/026 10:04
 * @VERSION 1.0
 **/

@Repository
public interface UserMapper {
    User sel(int id);

    User login(String userName, String passWord);

    int register(User user);
}
