package com.zhg.greenmall.controller;

import com.zhg.greenmall.entity.User;
import com.zhg.greenmall.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

@Controller
@CrossOrigin
public class TestController {
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }

    @Resource
    UserMapper userMapper;
    @RequestMapping("/user")
    @ResponseBody
    public User user(){
        return userMapper.findUserByName("test");
    }
}
