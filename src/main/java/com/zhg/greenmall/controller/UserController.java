package com.zhg.greenmall.controller;

import com.zhg.greenmall.entity.User;
import com.zhg.greenmall.service.serviceImpl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Resource
    UserServiceImpl userService;

    @PostMapping ("/add")
    public boolean addUser(@RequestBody User user){
        System.out.println(user);
        if(userService.findUserByName(user.getUsername())==null){
            return userService.addUser(user.getUsername(),user.getPassword());
        }else {
            return false;
        }



    }
}
