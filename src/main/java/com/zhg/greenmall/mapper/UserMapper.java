package com.zhg.greenmall.mapper;

import com.zhg.greenmall.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where user_name = #{user_name}")
    User findUserByName(String user_name);

    @Select("select * from user where user_name = #{user_name} and user_password = #{user_password}")
    User findUserByNameAndPassword(String user_name,String user_password);

    @Insert("insert into user(user_name,user_password) values (#{user_name},#{user_password})")
    void addUser(String user_name,String user_password);


}
