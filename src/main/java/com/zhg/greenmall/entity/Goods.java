package com.zhg.greenmall.entity;

import lombok.Data;

@Data
public class Goods {

    int goods_id;
    int store_id;
    String goods_time;
    String goods_name;
    String goods_photo;
    String goods_prices;
    String goods_stock;
    String goods_lable;
    String goods_description;
    String goods_state;
}
