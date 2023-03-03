package com.zhg.greenmall.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

    @RequestMapping("/user/add")
    public String test(){
        return "useradd";
    }
}
