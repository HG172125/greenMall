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

    @GetMapping("/test")
    public User test(){
        return userService.findUserByName("123");
    }

    @PostMapping("/userinfo")
    public User getUserByname(String name){
        return userService.findUserByName(name);
    }

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
