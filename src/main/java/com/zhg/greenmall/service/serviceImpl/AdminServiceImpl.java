package com.zhg.greenmall.service.serviceImpl;

import com.zhg.greenmall.entity.Admin;
import com.zhg.greenmall.mapper.AdminMapper;
import com.zhg.greenmall.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminMapper adminMapper;


    @Override
    public Admin findAdminByNameAndPass(String admin_name,String admin_password) {
        return adminMapper.findAdminByNameAndPass(admin_name,admin_password);
    }
}
