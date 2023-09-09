package com.situ.mapper;

import com.situ.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    Integer insertIntoUser(@Param("username") String username, @Param("password") String password);
    User findByUsername(String username);
    int updatePassword(@Param("username") String username ,@Param("password") String password,@Param("newPassword") String newPassword);
}
