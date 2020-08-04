package com.example.demo.service;


import com.example.demo.entity.User;

import java.util.List;

/**
 * 用户服务层借口
 */

public interface UserService {
    /**
     * 登录
     * @param username，password
     * @return
     */
    public User login(String username, String password);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    public boolean register(User user);


    List<User> findUserInfo();
}
