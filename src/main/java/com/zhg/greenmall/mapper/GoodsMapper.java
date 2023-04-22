package com.zhg.greenmall.mapper;

import com.zhg.greenmall.entity.Goods;
import com.zhg.greenmall.entity.GoodsShow;
import com.zhg.greenmall.entity.Store;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface GoodsMapper {

    /**
     * 修改商品状态
     */
    @Update("UPDATE goods SET goods_state=#{goods_state} WHERE goods_id=#{goods_id}")
    void updateState(String goods_state,int goods_id);


    /**
     * 查询所有商品
     **/
    @Select("SELECT\n" +
            "\tgoods.goods_id, \n" +
            "\tgoods.goods_time, \n" +
            "\tgoods.goods_name, \n" +
            "\tgoods.goods_photo, \n" +
            "\tstore.store_name, \n" +
            "\tgoods.goods_prices, \n" +
            "\tgoods.goods_stock,\n" +
            "\tgoods.goods_state\n" +
            "FROM\n" +
            "\tgoods\n" +
            "\tINNER JOIN\n" +
            "\tstore\n" +
            "\tON \n" +
            "\t\tgoods.store_id = store.store_id\n" +
            "GROUP BY\n" +
            "\tgoods.goods_id\n" +
            "ORDER BY\n" +
            "\tgoods.goods_time DESC")
    List<GoodsShow> findAllGoods();




    /**
     * 查询所有热门商品
     **/
    @Select("SELECT\n" +
            "\tgoods.goods_id, \n" +
            "\tgoods.goods_name, \n" +
            "\tSUM(`order`.order_goodsnumber) AS goods_state\n" +
            "FROM\n" +
            "\tgoods\n" +
            "\tINNER JOIN\n" +
            "\t`order`\n" +
            "\tON \n" +
            "\t\tgoods.goods_id = `order`.goods_id\n" +
            "GROUP BY\n" +
            "\tgoods.goods_id\n" +
            "ORDER BY\n" +
            "\tSUM(`order`.order_goodsnumber) DESC\n" +
            "LIMIT 8")
     List<Goods> findAllHotGoods();


    /**
     * 查询销量前8商品 id name 销量
     */
    @Select("SELECT\n" +
            "\tgoods.goods_id, \n" +
            "\tgoods.goods_name, \n" +
            "\tSUM(`order`.order_goodsnumber) AS goods_state\n" +
            "FROM\n" +
            "\tgoods\n" +
            "\tINNER JOIN\n" +
            "\t`order`\n" +
            "\tON \n" +
            "\t\tgoods.goods_id = `order`.goods_id\n" +
            "WHERE\n" +
            "\tgoods.store_id = #{store_id}\n" +
            "GROUP BY\n" +
            "\tgoods.goods_id")
    List<Goods> findgoodsNumberBysid(int store_id);


    /**
     * 修改库存
     */
    @Update("UPDATE goods SET goods_stock=#{goods_stock} WHERE goods_id=#{goods_id}")
    void updateStock(String goods_stock,int goods_id);


    /**
     * 通过gid删除商品
     */
    @Delete("DELETE FROM goods WHERE goods_id=#{goods_id}")
    void deleteGoodsByGid(int goods_id);

    /**
     * 添加商品
     */
    @Insert("insert into goods(store_id,goods_time," +
            "goods_name,goods_photo,goods_prices," +
            "goods_stock,goods_lable,goods_description) " +
            "VALUES(#{store_id},#{goods_time},#{goods_name}," +
            "#{goods_photo},#{goods_prices},#{goods_stock}," +
            "#{goods_lable},#{goods_description})")
    void addStore(int store_id,String goods_time,String goods_name,
                  String goods_photo, String goods_prices,
                  String goods_stock,String goods_lable,String goods_description);

    /**
     * 通过gid修改商品信息
     */
    @Update("UPDATE goods SET goods_name=#{goods_name}," +
            "goods_photo=#{goods_photo}," +
            "goods_prices=#{goods_prices}," +
            "goods_stock=#{goods_stock}," +
            "goods_lable=#{goods_lable}," +
            "goods_description=#{goods_description}" +
            "WHERE goods_id=#{goods_id}")
    void updateGoods(String goods_name,String goods_photo,
                     String goods_prices, String goods_stock,
                     String goods_lable,String goods_description,
                     int goods_id);

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
            "\tgoods.goods_id, \n" +
            "\tgoods.store_id, \n" +
            "\tgoods.goods_time, \n" +
            "\tgoods.goods_name, \n" +
            "\tgoods.goods_photo, \n" +
            "\tgoods.goods_prices, \n" +
            "\tgoods.goods_stock, \n" +
            "\tgoods.goods_lable, \n" +
            "\tgoods.goods_description, \n" +
            "\tgoods.goods_state\n" +
            "FROM\n" +
            "\tgoods\n" +
            "WHERE\n" +
            "\tgoods.store_id = #{store_id}\n" +
            "ORDER BY\n" +
            "\tgoods.goods_time DESC")
    ArrayList<Goods> findAllGooodsBySid(int store_id);

    /**
     * 查询热门商品
     */
    @Select("SELECT\n" +
            "\tgoods.goods_id, \n" +
            "\tgoods.store_id, \n" +
            "\tgoods.goods_name, \n" +
            "\tgoods.goods_photo, \n" +
            "\tgoods.goods_prices, \n" +
            "\tgoods.goods_stock, \n" +
            "\tgoods.goods_lable, \n" +
            "\tgoods.goods_description, \n" +
            "\t`order`.order_goodsnumber, \n" +
            "\tSUM(`order`.order_goodsnumber)\n" +
            "FROM\n" +
            "\tgoods\n" +
            "\tINNER JOIN\n" +
            "\t`order`\n" +
            "\tON \n" +
            "\t\tgoods.goods_id = `order`.goods_id\n" +
            "GROUP BY\n" +
            "\tgoods.goods_id\n" +
            "ORDER BY\n" +
            "\tSUM(`order`.order_goodsnumber) DESC\n" +
            "LIMIT 8")
    List<GoodsShow> findHotGoods();

    /**
     * 查询新添加商品
     */
    @Select("SELECT\n" +
            "\tgoods.goods_id, \n" +
            "\tgoods.store_id, \n" +
            "\tgoods.goods_name, \n" +
            "\tgoods.goods_photo, \n" +
            "\tgoods.goods_prices, \n" +
            "\tgoods.goods_stock, \n" +
            "\tgoods.goods_lable, \n" +
            "\tgoods.goods_description, \n" +
            "\tgoods.goods_time\n" +
            "FROM\n" +
            "\tgoods\n" +
            "GROUP BY\n" +
            "\tgoods.goods_id\n" +
            "ORDER BY\n" +
            "\tgoods.goods_time DESC\n" +
            "LIMIT 8")
    List<GoodsShow> findNewGoods();

    /**
     * 查询水果商品
     */
    @Select("SELECT\n" +
            "\tgoods.*, \n" +
            "\tSUM(`order`.order_goodsnumber)\n" +
            "FROM\n" +
            "\tgoods\n" +
            "\tINNER JOIN\n" +
            "\t`order`\n" +
            "\tON \n" +
            "\t\tgoods.goods_id = `order`.goods_id\n" +
            "WHERE\n" +
            "\tgoods.goods_lable LIKE '%水果%'\n" +
            "GROUP BY\n" +
            "\tgoods.goods_id\n" +
            "ORDER BY\n" +
            "\tSUM(`order`.order_goodsnumber) DESC\n" +
            "LIMIT 8")
    List<Goods> findFruitGoods();

    /**
     * 查询蔬菜商品
     */
    @Select("SELECT\n" +
            "\t*, \n" +
            "\tgoods.goods_id, \n" +
            "\tgoods.store_id, \n" +
            "\tgoods.goods_time, \n" +
            "\tgoods.goods_name, \n" +
            "\tgoods.goods_photo, \n" +
            "\tgoods.goods_prices, \n" +
            "\tgoods.goods_stock, \n" +
            "\tgoods.goods_lable, \n" +
            "\tgoods.goods_description, \n" +
            "\tgoods.goods_state\n" +
            "FROM\n" +
            "\tgoods\n" +
            "WHERE\n" +
            "\tgoods.goods_lable LIKE '%蔬菜%'\n" +
            "ORDER BY\n" +
            "\tgoods.goods_time DESC\n" +
            "LIMIT 8")
    List<Goods> findVegetableGoods();

    /**
     * 通过信息查找商品
     */
    @Select("SELECT\n" +
            "\tgoods.goods_id, \n" +
            "\tgoods.store_id, \n" +
            "\tgoods.goods_time, \n" +
            "\tgoods.goods_name, \n" +
            "\tgoods.goods_photo, \n" +
            "\tgoods.goods_prices, \n" +
            "\tgoods.goods_stock, \n" +
            "\tgoods.goods_lable, \n" +
            "\tgoods.goods_description, \n" +
            "\tgoods.goods_state\n" +
            "FROM\n" +
            "\tgoods\n" +
            "WHERE\n" +
            "\tgoods.goods_name LIKE #{sel} OR\n" +
            "\tgoods.goods_lable LIKE #{sel} OR\n" +
            "\tgoods.goods_description LIKE #{sel}")
   List<Goods> findGoodsBySelect(String sel);

}
