package com.zhg.greenmall.entity;

import lombok.Data;

@Data
public class Goods {

    int goods_id;// 商品id
    int store_id;// 店铺id
    String goods_time;// 商品创建时间
    String goods_name;// 商品名称
    String goods_photo;// 商品照片
    String goods_prices;// 商品价格
    String goods_stock;// 商品库存
    String goods_lable;// 商品标签
    String goods_description;// 商品描述
    String goods_state;// 商品状态
}
