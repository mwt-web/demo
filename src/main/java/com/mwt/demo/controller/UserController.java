package com.mwt.demo.controller;


import com.mwt.demo.config.AjaxResult;
import com.mwt.demo.entity.User;
import com.mwt.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author muwentao
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> getUserInfo(){
        List<User> list=userService.findUserInfo();
        return list;
    }

    @PostMapping(value = "/login")
    public AjaxResult login(@RequestBody User user){
        return userService.login(user);
    }

    @PostMapping("/register")
    public AjaxResult register(User user){
        return userService.register(user);
    }
}
