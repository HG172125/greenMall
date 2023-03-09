package com.zhg.greenmall.service.serviceImpl;

import com.zhg.greenmall.entity.User;
import com.zhg.greenmall.mapper.UserMapper;
import com.zhg.greenmall.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    /**
     *添加用户
     */
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

    /**
     * 登录查询
     */
    @Override
    public User findUserByNameAndPassword(String username, String password) {
           return userMapper.findUserByNameAndPassword(username,password);
    }


}
