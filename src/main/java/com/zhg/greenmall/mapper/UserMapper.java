package com.zhg.greenmall.mapper;

import com.zhg.greenmall.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

@Mapper
public interface UserMapper {
    @Select("select * from user where user_name = #{user_name}")
    User findUserByName(String user_name);

    @Select("select * from user where user_name = #{user_name} and user_password = #{user_password}")
    User findUserByNameAndPassword(String user_name,String user_password);

    @Insert("insert into user(user_name,user_password) values (#{user_name},#{user_password})")
    void addUser(String user_name,String user_password);

    @Select("select * from user")
    ArrayList<User> findAllUser();

    @Update("UPDATE `user`  SET user_name=#{user_name},user_phone=#{user_phone},user_address=#{user_address} WHERE user_id=#{user_id}")
    void updateUser(String user_name,String user_phone,String user_address,int user_id);
    @Update("UPDATE `user`  SET user_password=#{user_password} WHERE user_id=#{user_id}")
    void updateUserPass(String user_password,int user_id);


}
