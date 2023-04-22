package com.zhg.greenmall.service.serviceImpl;

import com.zhg.greenmall.entity.Goods;
import com.zhg.greenmall.entity.GoodsShow;
import com.zhg.greenmall.mapper.GoodsMapper;
import com.zhg.greenmall.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    GoodsMapper goodsMapper;
    /**
     * 修改商品状态
     */
    @Override
    public Boolean updateState(String goods_state, int goods_id) {
        System.out.println("修改商品状态"+goods_id+goods_state);
        try {
            goodsMapper.updateState(goods_state,goods_id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 查询所有商品
     **/
    @Override
    public List<GoodsShow> findAllGoods(){
        return goodsMapper.findAllGoods();
    }

    @Override
    public List<Goods> findAllHotGoods() {
        System.out.println("all hotgoods");
        return goodsMapper.findAllHotGoods();
    }

    /**
     * 查询销量前8商品 id name 销量
     */
    @Override
    public List<Goods> findgoodsNumberBysid(int store_id){
        return goodsMapper.findgoodsNumberBysid(store_id);
    }

    /**
     * 通过信息查找商品
     */
    @Override
    public List<Goods> findGoodsBySelect(String sel) {

       return goodsMapper.findGoodsBySelect(sel);
    }

    /**
     * 查询水果商品
     */
    @Override
    public List<Goods> findFruitGoods() {
        return goodsMapper.findFruitGoods();
    }

    /**
     * 查询蔬菜商品
     */
    @Override
    public List<Goods> findVegetableGoods(){
        return goodsMapper.findVegetableGoods();
    }

    /**
     * 修改库存
     */
    @Override
    public boolean updateStock(String goods_stock,int goods_id) {
        try {
            goodsMapper.updateStock(goods_stock,goods_id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 查询新添加商品
     */
    @Override
    public List<GoodsShow> findNewGoods() {
        return goodsMapper.findNewGoods();
    }

    /**
     * 查询热门商品
     */
    @Override
    public List<GoodsShow> findHotGoods() {
        return goodsMapper.findHotGoods();
    }

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
