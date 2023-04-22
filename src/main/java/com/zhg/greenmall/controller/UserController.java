package com.zhg.greenmall.controller;

import com.zhg.greenmall.entity.User;
import com.zhg.greenmall.mapper.UserMapper;
import com.zhg.greenmall.service.serviceImpl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Resource
    UserServiceImpl userService;

    /**
     * 修改用户状态
     */
    @PostMapping("/updateUserState")
    public Boolean updateUserState(@RequestBody User user){
        return userService.updateUserState(user.getUser_state(), user.getUser_id());
    }


    @PostMapping("/deleteUserByUid")
    public Boolean deleteUserByUid(@RequestBody User user){
       return userService.deleteUserByUid(user.getUser_id());
    }


    @PostMapping("/findAllUser")
    public List<User> findAllUser(){
        return userService.findAllUser();
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
        return userService.addUser(user.getUser_name(),user.getUser_password(), user.getUser_time(), user.getUser_phone(), user.getUser_address());
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

    @PostMapping("updete")
    public Boolean updeteUser(@RequestBody User user){
        System.out.println("修改用户"+user.getUser_id());
        System.out.println(user.getUser_name());
        System.out.println(user.getUser_address());
        return userService.updateUser(user.getUser_name(),user.getUser_phone(),user.getUser_address(),user.getUser_id());
    }

    @PostMapping("updetePass")
    public Boolean updeteUserPass(@RequestBody User user){
        System.out.println("修改用户密码"+user.getUser_id());
        return userService.updateUserPass(user.getUser_password(),user.getUser_id());
    }
}
