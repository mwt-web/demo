package com.mwt.demo.mapper;


import com.mwt.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author muwentao
 */
@Mapper
public interface UserMapper {
    /**
     * 登录 对象可以直接被解析出去吗？肯定不能啊，你要写陈String usernamem,String password就可以，吧刚刚那个加上自动注入不爆红
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 注册
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 查询所有
     * @return
     */
    //@Select("select * from user")
    List<User> findUserInfo();
}
