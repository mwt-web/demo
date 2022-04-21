package com.mwt.demo.service.imp;



import com.mwt.demo.config.AjaxResult;
import com.mwt.demo.mapper.UserMapper;
import com.mwt.demo.entity.User;
import com.mwt.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    /**
     * 自动注入dao层
     *
     *
     */
    @Autowired
    private UserMapper userMapper;

    @Override
    public AjaxResult login(User user) {
        if(user.getUsername()==null||user.getPassword()==null) {
            return null;
        }
        User loginuser = userMapper.login(user);
        if(loginuser!=null)
            return AjaxResult.success("登陆成功");
        return AjaxResult.error("登录失败");

    }

    @Override
    public AjaxResult register(User user) {
        if(user!=null) {
            int row = userMapper.register(user);
            if (row > 0) {
                return AjaxResult.success("注册成功");
            }
        }
        return AjaxResult.error("注册失败");
    }

    @Override
    public List<User> findUserInfo() {
        return userMapper.findUserInfo();
    }
}
