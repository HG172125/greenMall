package com.zhg.greenmall.service.serviceImpl;

import com.zhg.greenmall.entity.User;
import com.zhg.greenmall.mapper.UserMapper;
import com.zhg.greenmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean addUser(String username, String password) {
        try {
            userMapper.addUser(username,password);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public User findUserByName(String name) {
        return userMapper.findUserByName(name);
    }
}
