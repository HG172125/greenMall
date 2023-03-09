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
    public boolean addStore(int sid,String gname, String gimage, String gprices, String glable, String gintroduce) {
        try {
            goodsMapper.addStore(sid,gname,gimage,gprices,glable,gintroduce);
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
    public boolean updateGoods(String gname,String gimage,String gprices,String glable,String gintroduce,int gid) {
        try {
            goodsMapper.updateGoods(gname,gimage,gprices,glable,gintroduce,gid);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
