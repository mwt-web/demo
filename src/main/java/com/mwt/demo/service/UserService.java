package com.mwt.demo.service;


import com.mwt.demo.config.AjaxResult;
import com.mwt.demo.entity.User;

import java.util.List;

/**
 * 用户服务层借口
 */

public interface UserService {
    /**
     * 登录
     * @param user
     * @return
     */
    AjaxResult login(User user);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    AjaxResult register(User user);


    List<User> findUserInfo();
}
