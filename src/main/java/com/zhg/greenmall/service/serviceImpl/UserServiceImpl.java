package com.zhg.greenmall.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.zhg.greenmall.entity.User;
import com.zhg.greenmall.mapper.UserMapper;
import com.zhg.greenmall.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.annotation.ElementType;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public Boolean deleteUserByUid(int user_id) {
        try {
            userMapper.deleteUserByUid(user_id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    /**
     *添加用户
     */
    @Override
    public Boolean addUser(String user_name,String user_password,String user_time,String user_phone,String user_address) {
        try {
            userMapper.addUser(user_name,user_password,user_time,user_phone,user_address);
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

    /**
     * 修改用户状态
     */
    @Override
    public Boolean updateUserState(String user_state, int user_id) {
        System.out.println("修改用户状态"+user_id+user_state);
        try {
            userMapper.updateUserState(user_state,user_id);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
