package com.zhg.greenmall.mapper;

import com.zhg.greenmall.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface UserMapper {


    @Delete("DELETE FROM user WHERE user_id=#{user_id}")
    void deleteUserByUid(int user_id);



    /**
    * 修改用户状态
    */
    @Update("UPDATE `user`  SET user_state=#{user_state} WHERE user_id=#{user_id}")
    void updateUserState(String user_state,int user_id);


    /**
     * 查询所有用户
     */
    @Select("SELECT\n" +
            "\t`user`.user_id, \n" +
            "\t`user`.user_time, \n" +
            "\t`user`.user_name, \n" +
            "\t`user`.user_password, \n" +
            "\t`user`.user_phone, \n" +
            "\t`user`.user_address, \n" +
            "\t`user`.user_state\n" +
            "FROM\n" +
            "\t`user`")
    List<User> findAllUser();

    @Select("select * from user where user_name = #{user_name}")
    User findUserByName(String user_name);

    /**
     * 用户登录查询
     */
    @Select("select * from user " +
            "where user_name = #{user_name} and " +
            "user_password = #{user_password} and " +
            "`user`.user_state <> '禁用'")
    User findUserByNameAndPassword(String user_name,String user_password);

    @Insert("insert into " +
            "user(user_name,user_password,user_time,user_phone,user_address,user_state) " +
            "values (#{user_name},#{user_password},#{user_time},#{user_phone},#{user_address},'启用')")
    void addUser(String user_name,String user_password,String user_time,String user_phone,String user_address);

    @Update("UPDATE `user`  SET user_name=#{user_name},user_phone=#{user_phone},user_address=#{user_address} WHERE user_id=#{user_id}")
    void updateUser(String user_name,String user_phone,String user_address,int user_id);

    @Update("UPDATE `user`  SET user_password=#{user_password} WHERE user_id=#{user_id}")
    void updateUserPass(String user_password,int user_id);


}
