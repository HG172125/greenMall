package com.zhg.greenmall.entity;

import lombok.Data;

@Data
public class User {

    int user_id;//用户id
    String user_time;
    String user_name;//用户姓名
    String user_password;//用户密码
    String user_phone;//用户电话
    String user_address;//用户地址
    String user_state;
}
