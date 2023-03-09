package com.zhg.greenmall.service;


import com.zhg.greenmall.entity.Goods;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

public interface GoodsService {

    boolean addStore(int sid,String gname,String gimage ,String gprices,String glable,String gintroduce);
    Goods findGoodsById(int sid);
    ArrayList<Goods> findAllGooodsBySid(int sid);
    boolean updateGoods(String gname,String gimage,String gprices,String glable,String gintroduce,int gid);
    boolean deleteGoodsByGid(int gid);
}
