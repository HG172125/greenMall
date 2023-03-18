package com.zhg.greenmall.controller;

import com.github.pagehelper.PageHelper;
import com.zhg.greenmall.entity.Admin;
import com.zhg.greenmall.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminContoller {

    @Resource
    AdminService adminService;

    @PostMapping("/login")
    public Admin login(@RequestBody Admin admin){
        System.out.println("adminlogin"+admin.getAdmin_name());
        return adminService.findAdminByNameAndPass(admin.getAdmin_name(), admin.getAdmin_password());
    }

}
