package com.zhg.greenmall.controller;

import com.zhg.greenmall.entity.User;
import com.zhg.greenmall.service.serviceImpl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


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

    @PostMapping("/login")
    public String login(@RequestBody User user){
        System.out.println(user);

        if (userService.findUserByName(user.getUsername())==null){
            return "1";
        }else if (userService.findUserByNameAndPassword(user.getUsername(), user.getPassword())==null){
            return "2";
        }else {
            return "3";
        }
    }
}
