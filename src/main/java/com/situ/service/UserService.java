package com.situ.service;

import com.situ.bean.User;

public interface UserService {
    User findUserByUsernameAndPassword(String username,String password);
    Integer signUp(String username,String password);
    User findByUsername(String username);
    int updatePassword(String username ,String password,String newPassword) throws Exception;
}
