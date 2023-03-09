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
    public User getUserByName(String name){
        return userService.findUserByName(name);
    }

    /**
     *添加用户
     */
    @PostMapping ("/add")
    public boolean addUser(@RequestBody User user){
        System.out.println("添加用户"+user);
        return userService.addUser(user.getUser_name(),user.getUser_password());
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public User login(@RequestBody User user){
        System.out.println("登录查询用户"+user);
        System.out.println("查询结果："+userService.findUserByNameAndPassword(user.getUser_name(),user.getUser_password()));
       return userService.findUserByNameAndPassword(user.getUser_name(),user.getUser_password());
    }
}
