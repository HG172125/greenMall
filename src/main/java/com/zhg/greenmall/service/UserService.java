package com.zhg.greenmall.service;

import com.zhg.greenmall.entity.User;

public interface UserService {
    boolean addUser(String name,String Password);
    User findUserByName(String name);
}
