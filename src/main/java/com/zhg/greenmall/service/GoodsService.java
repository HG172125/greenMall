package com.zhg.greenmall.service;


import com.zhg.greenmall.entity.Goods;

public interface GoodsService {

    boolean addStore(int sid,String gname,String gimage ,String gprices,String glable,String gintroduce);
    Goods findGoodsById(int gid);
}
