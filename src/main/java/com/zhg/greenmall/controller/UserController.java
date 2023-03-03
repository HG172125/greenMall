package com.zhg.greenmall.controller;

import com.zhg.greenmall.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;
    @RequestMapping("/add")
    public boolean addUser(String username,String password ){

        if(userService.findUserByName(username)==null){
            return userService.addUser(username,password);
        }else {
            return true;
        }



    }
}
