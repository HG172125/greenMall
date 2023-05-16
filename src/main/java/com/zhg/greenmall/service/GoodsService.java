package com.zhg.greenmall.service;


import com.zhg.greenmall.entity.Goods;
import com.zhg.greenmall.entity.GoodsShow;
import com.zhg.greenmall.entity.Store;
import org.apache.ibatis.annotations.Select;


import java.util.ArrayList;
import java.util.List;

public interface GoodsService {

    /**
     * 修改商品状态
     */
    Boolean updateState(String goods_state,int goods_id);

    /**
     * 查询所有商品
     **/
    List<GoodsShow> findAllGoods();

    /**
     * 查询所有热门商品
     **/
    List<Goods> findAllHotGoods();

    /**
     * 查询销量前8商品 id name 销量
     */
    List<Goods> findgoodsNumberBysid(int store_id);


    /**
     * 通过信息查找商品
     */
    List<Goods> findGoodsBySelect(String sel);
    /**
     * 修改库存
     */
    boolean updateStock(String goods_stock,int goods_id);

    List<GoodsShow> findNewGoods();

    List<GoodsShow> findHotGoods();

   boolean addStore(int store_id,String goods_time,String goods_name,String goods_photo,
                    String goods_prices,String goods_stock,String goods_lable,String goods_description);

    Goods findGoodsById(int sid);

    ArrayList<Goods> findAllGooodsBySid(int sid);

    boolean updateGoods(String goods_name,String goods_photo,String goods_prices,
                        String goods_stock,String goods_lable,String goods_description,int goods_id);

    boolean deleteGoodsByGid(int gid);

    List<Goods> findFruitGoods();

    List<Goods> findVegetableGoods();
}
