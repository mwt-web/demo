package com.mwt.demo.service.imp;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mwt.demo.config.AjaxResult;
import com.mwt.demo.entity.SysUser;
import com.mwt.demo.mapper.UserMapper;
import com.mwt.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author muwentao
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,SysUser> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public AjaxResult login(SysUser user) {
        if(user.getUsername()==null||user.getPassword()==null) {
            return AjaxResult.error("用户名和密码不能为空");
        }
        SysUser loginUser = userMapper.login(user);
        if(loginUser!=null) {
            return AjaxResult.success("登陆成功");
        }
        return AjaxResult.error("登录失败");

    }

    @Override
    public AjaxResult register(SysUser user) {
        if(user!=null) {
            QueryWrapper<SysUser> qw = new QueryWrapper<>();
            qw.eq("username",user.getUsername());
            List<SysUser> list = userMapper.selectList(qw);
            if(ObjectUtils.isNotEmpty(list)){
                log.info("{}",list);
                return AjaxResult.error("用户已存在");
            }
            int row = userMapper.register(user);
            if (row > 0) {
                return AjaxResult.success("注册成功");
            }
        }
        return AjaxResult.error("注册失败");
    }

    @Override
    public List<SysUser> findUserInfo() {
        return userMapper.findUserInfo();
    }
}
