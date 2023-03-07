package com.zhg.greenmall.mapper;

import com.zhg.greenmall.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User findUserByName(String username);

    @Select("select * from user where username = #{username} and password = #{password}")
    User findUserByNameAndPassword(String username,String password);

    @Insert("insert into user(username,password) values (#{username},#{password})")
    void addUser(String username,String password);


}
