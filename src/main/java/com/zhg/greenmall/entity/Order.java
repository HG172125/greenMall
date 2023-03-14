package com.zhg.greenmall.entity;

import lombok.Data;

@Data
public class Order {
    int order_id;
    int user_id;
    int goods_id;
    int order_goodsnumber;
    String order_time;
    String order_state;
}
