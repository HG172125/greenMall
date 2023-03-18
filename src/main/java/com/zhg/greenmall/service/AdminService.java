package com.zhg.greenmall.service;

import com.zhg.greenmall.entity.Admin;

public interface AdminService {
    Admin findAdminByNameAndPass(String admin_name,String admin_password);
}
