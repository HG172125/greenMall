package com.zhg.greenmall.mapper;

import com.zhg.greenmall.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface GoodsMapper {

    /**
     * 通过gid删除商品
     */
    @Delete("DELETE FROM goods WHERE goods_id=#{goods_id}")
    void deleteGoodsByGid(int goods_id);

    /**
     * 添加商品
     */
    @Insert("insert into goods(store_id,goods_time,goods_name,goods_photo,goods_prices,goods_stock,goods_lable,goods_description) " +
            "VALUES(#{store_id},#{goods_time},#{goods_name},#{goods_photo},#{goods_prices},#{goods_stock},#{goods_lable},#{goods_description})")
    void addStore(int store_id,String goods_time,String goods_name,String goods_photo,
                  String goods_prices,String goods_stock,String goods_lable,String goods_description);

    /**
     * 通过gid修改商品信息
     */
    @Update("UPDATE goods SET goods_name=#{goods_name},goods_photo=#{goods_photo}," +
            "goods_prices=#{goods_prices},goods_stock=#{goods_stock},goods_lable=#{goods_lable}," +
            "gintroduce=#{goods_description}  WHERE gid=#{goods_id}")
    void updateGoods(String goods_name,String goods_photo,String goods_prices,
                     String goods_stock,String goods_lable,String goods_description,int goods_id);

    /**
     * 通过gid查找商品
     */
    @Select("SELECT\n" +
            "\tgoods.*\n" +
            "FROM\n" +
            "\tgoods\n" +
            "WHERE\n" +
            "\tgoods.goods_id = #{goods_id}")
    Goods findGoodsById(int goods_id);

    /**
     * 通过sid查找所有商品
     */
    @Select("SELECT\n" +
            "\t*, \n" +
            "\tgoods.*\n" +
            "FROM\n" +
            "\tgoods\n" +
            "WHERE\n" +
            "\tgoods.store_id = #{store_id}")
    ArrayList<Goods> findAllGooodsBySid(int store_id);


}
