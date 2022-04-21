package com.mwt.demo.controller;


import com.mwt.demo.config.AjaxResult;
import com.mwt.demo.entity.SysUser;
import com.mwt.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<SysUser> getSysUserInfo(){
        List<SysUser> list=userService.findUserInfo();
        return list;
    }

    @PostMapping(value = "/login")
    public AjaxResult login(@RequestBody SysUser SysUser){
        return userService.login(SysUser);
    }

    @PostMapping("/register")
    public AjaxResult register(SysUser SysUser){
        return userService.register(SysUser);
    }
}
