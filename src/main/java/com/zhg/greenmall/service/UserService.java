package com.zhg.greenmall.service;

import com.zhg.greenmall.entity.User;

import java.util.List;

public interface UserService {
    Boolean deleteUserByUid(int user_id);
    List<User> findAllUser();
    Boolean addUser(String user_name,String user_password,String user_time,String user_phone,String user_address);
    User findUserByName(String name);
    User findUserByNameAndPassword(String username,String password);
    Boolean updateUser(String user_name,String user_phone,String user_address,int user_id);
    Boolean updateUserPass(String user_password,int user_id);
    Boolean updateUserState(String user_state,int user_id);
}
