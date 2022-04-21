package com.mwt.demo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mwt.demo.config.AjaxResult;
import com.mwt.demo.entity.SysUser;

import java.util.List;

/**
 * 用户服务层借口
 */

public interface UserService extends IService<SysUser> {
    /**
     * 登录
     * @param user
     * @return
     */
    AjaxResult login(SysUser user);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    AjaxResult register(SysUser user);


    List<SysUser> findUserInfo();
}
