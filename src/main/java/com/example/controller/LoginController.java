package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author ChainSmoker
 * @Date 2018/11/26/026 11:06
 * @VERSION 1.0
 **/
@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;

    //跳转到首页
    @RequestMapping("/toIndex")
    public String show() {
        return "index";
    }

    //登录
    @ResponseBody
    @RequestMapping("/loginUser")
    public String loginUser(User user, HttpServletRequest request) {
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        User u = userService.login(userName, passWord);

        if (u == null) {
            return "用户名或密码错误";
        } else {
            request.getSession().setAttribute("session_user", user);
            return "登录成功";
        }
    }

    //跳转注册页
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    //注册操作
    @RequestMapping("/register")
    public String register(User user) {
        int su = userService.register(user);
        if (su == 0) {
            System.out.println("----");
        }
        return "welcome";
    }

    //测试未登陆拦截页面
    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    //退出登录
    @RequestMapping("/outUser")
    public void outUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("session_user");
        response.sendRedirect("/user/toIndex");
    }
}
