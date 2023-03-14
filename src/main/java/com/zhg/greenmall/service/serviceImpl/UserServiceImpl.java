package com.zhg.greenmall.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.zhg.greenmall.entity.User;
import com.zhg.greenmall.mapper.UserMapper;
import com.zhg.greenmall.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.annotation.ElementType;


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

    @Override
    public Boolean updateUser(String user_name, String user_phone, String user_address, int user_id) {
        try {
            userMapper.updateUser(user_name,user_phone,user_address,user_id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean updateUserPass(String user_password, int user_id) {
        try {
            userMapper.updateUserPass(user_password,user_id);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
