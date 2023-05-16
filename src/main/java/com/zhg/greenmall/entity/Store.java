package com.zhg.greenmall.entity;

import lombok.Data;

@Data
public class Store {
    int store_id;//店铺id
    String store_time;
    String store_name;//店铺名字
    String store_username;//店铺用户名
    String store_password;//店铺登录密码
    String store_state;
    String store_number;
}
