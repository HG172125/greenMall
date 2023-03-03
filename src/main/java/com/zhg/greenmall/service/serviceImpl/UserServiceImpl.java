package com.zhg.greenmall.service.serviceImpl;

import com.zhg.greenmall.dao.UserDAo;
import com.zhg.greenmall.entity.User;
import com.zhg.greenmall.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    UserDAo userDAo;

    @Override
    public void addUser(String username, String password) {

        userDAo.addUser(username, password);
    }
}
