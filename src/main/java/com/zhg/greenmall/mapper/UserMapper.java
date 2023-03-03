package com.zhg.greenmall.mapper;

import com.zhg.greenmall.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Vector;

@Mapper

public interface UserMapper {

    @Select("select * from user")
    Vector<User> findAll();

    @Select("select * from user where username = #{username}")
    User findUserByName(String username);

    @Insert("insert into user(username,password) values (#{username},#{password})")
    void addUser(String username,String password);
}
