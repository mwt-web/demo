package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> getUserInfo(){
        List<User> list=userService.findUserInfo();
        //User user=null;
        return list;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    //@ResponseBody
    public User login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        /**
         * 测试模拟数据
         */
       /* User user=new User();
        user.setUsername("mwt");
        user.setPassword("123456");
        if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
            session.setAttribute("user",user);
            return user;
        }
        return user;*/

        User user=userService.login(username,password);
        session.setAttribute("user",user);
        return user;
    }

    @RequestMapping("/register")
    public String register(User user){
        /**
         * 模拟测试
         */
        //return "注册成功\n"+user.toString();

        boolean state = userService.register(user);
        if(state){
            return "注册成功";
        }
        return "注册失败";
    }
}
