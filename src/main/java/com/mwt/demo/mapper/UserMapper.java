package com.mwt.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mwt.demo.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author muwentao
 */
@Mapper
public interface UserMapper extends BaseMapper<SysUser> {
    /**
     * 登录 对象可以直接被解析出去吗？肯定不能啊，你要写陈String usernamem,String password就可以，吧刚刚那个加上自动注入不爆红
     * @param user
     * @return
     */
    SysUser login(SysUser user);

    /**
     * 注册
     * @param user
     * @return
     */
    int register(SysUser user);

    /**
     * 查询所有
     * @return
     */
    List<SysUser> findUserInfo();
}
