package com.zhg.greenmall.entity;

import lombok.Data;

@Data
public class User {
    int uid;
    String username;
    String password;
    String useraddress;
    String userphone;
    String roles;
}
