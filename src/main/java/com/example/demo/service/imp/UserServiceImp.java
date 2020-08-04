package com.example.demo.service.imp;



import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    /**
     * 自动注入dao层
     */
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        if(username==null||password==null) {
            return null;
        }
        User user = userDao.login(username, password);
        if(user!=null)
            return user;
        return null;

    }

    @Override
    public boolean register(User user) {
        if(user!=null) {
            int row = userDao.register(user);
            if (row > 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public List<User> findUserInfo() {
        return userDao.findUserInfo();
    }
}
