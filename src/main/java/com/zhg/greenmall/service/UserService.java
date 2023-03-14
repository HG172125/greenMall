package com.zhg.greenmall.service;

import com.zhg.greenmall.entity.User;

public interface UserService {
    boolean addUser(String name,String Password);
    User findUserByName(String name);
    User findUserByNameAndPassword(String username,String password);
    Boolean updateUser(String user_name,String user_phone,String user_address,int user_id);
    Boolean updateUserPass(String user_password,int user_id);
}
