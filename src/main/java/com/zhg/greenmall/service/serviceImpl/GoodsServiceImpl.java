package com.zhg.greenmall.service.serviceImpl;

import com.zhg.greenmall.entity.Goods;
import com.zhg.greenmall.mapper.GoodsMapper;
import com.zhg.greenmall.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    GoodsMapper goodsMapper;

    /**
     *添加
     */
    @Override
   public boolean addStore(int store_id,String goods_time,String goods_name,String goods_photo,
                     String goods_prices,String goods_stock,String goods_lable,String goods_description)
    {
        try {
            goodsMapper.addStore(store_id,goods_time,goods_name,goods_photo,
                    goods_prices,goods_stock,goods_lable,goods_description);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Goods findGoodsById(int gid) {
        return goodsMapper.findGoodsById(gid);
    }

    @Override
    public ArrayList<Goods> findAllGooodsBySid(int sid) {
        return goodsMapper.findAllGooodsBySid(sid);
    }

    @Override
    public boolean updateGoods(String goods_name,String goods_photo,String goods_prices,
                               String goods_stock,String goods_lable,String goods_description,int goods_id){
        try {
            goodsMapper.updateGoods(goods_name,goods_photo,goods_prices,goods_stock,goods_lable,goods_description,goods_id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteGoodsByGid(int gid) {
        try {
            goodsMapper.deleteGoodsByGid(gid);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
