package com.example.demo.dao;


import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserDao {
    /**
     * 登录 对象可以直接被解析出去吗？肯定不能啊，你要写陈String usernamem,String password就可以，吧刚刚那个加上自动注入不爆红
     * @param username,password
     * @return
     */
    User login(String username, String password);

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
