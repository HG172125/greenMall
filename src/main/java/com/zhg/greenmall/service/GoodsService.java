package com.zhg.greenmall.service;


import com.zhg.greenmall.entity.Goods;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

public interface GoodsService {

   boolean addStore(int store_id,String goods_time,String goods_name,String goods_photo,
                    String goods_prices,String goods_stock,String goods_lable,String goods_description);

    Goods findGoodsById(int sid);
    ArrayList<Goods> findAllGooodsBySid(int sid);
    boolean updateGoods(String goods_name,String goods_photo,String goods_prices,
                        String goods_stock,String goods_lable,String goods_description,int goods_id);
    boolean deleteGoodsByGid(int gid);
}
