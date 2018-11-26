package com.example.controller;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author ChainSmoker
 * @Date 2018/11/26/026 10:03
 * @VERSION 1.0
 **/

@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        return userService.sel(id).toString();
    }
}
