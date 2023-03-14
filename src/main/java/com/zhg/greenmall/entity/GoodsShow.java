package com.zhg.greenmall.entity;

import lombok.Data;

@Data
public class GoodsShow {
    int goods_id;// 商品id
    String goods_time;// 商品创建时间
    String goods_name;// 商品名称
    String goods_photo;// 商品照片
    String goods_prices;// 商品价格
    String goods_stock;// 商品库存
    String goods_lable;// 商品标签
    String goods_description;// 商品描述


    int store_id;//店铺id
    String store_name;//店铺名字
    String store_username;//店铺用户名

    int order_id;
    int user_id;
    int order_goodsnumber;
    String order_time;
    String order_state;

    String user_name;//用户姓名
    String user_password;//用户密码
    String user_phone;//用户电话
    String user_address;//用户地址
}
