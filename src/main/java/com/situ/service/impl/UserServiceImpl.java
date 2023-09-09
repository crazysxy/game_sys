package com.situ.service.impl;

import com.situ.bean.User;
import com.situ.mapper.UserMapper;
import com.situ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {
    //private UserDao userDao= new UserDaoImpl();
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return userMapper.findUserByUsernameAndPassword(username, password);
    }

    @Override
    public Integer signUp(String username, String password) {
        return userMapper.insertIntoUser(username, password);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public int updatePassword(String username, String password, String newPassword) throws Exception {

        User user = userMapper.findByUsername(username);
        if(user.getPassword().equals(newPassword)){
            throw  new Exception("新密码不能与旧密码相同");
        }
        return userMapper.updatePassword(username, password, newPassword);
    }
}
