package com.zhg.greenmall.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.web.bind.annotation.RequestMapping;


public interface UserDAo {
    @Insert("insert into user(username,password) values (#{username},#{password})")
    void addUser(String username,String password);
}
