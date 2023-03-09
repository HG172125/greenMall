package com.zhg.greenmall.mapper;

import com.zhg.greenmall.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface GoodsMapper {

    /**
     * 通过gid删除商品
     */
    @Delete("DELETE FROM goods WHERE gid=#{gid}")
    void deleteGoodsByGid(int gid);

    /**
     * 添加商品
     */
    @Insert("insert into goods(sid,gname,gimage,gprices,glable,gintroduce) VALUES(#{sid},#{gname},#{gimage},#{gprices},#{glable},#{gintroduce})")
    void addStore(int sid,String gname,String gimage ,String gprices,String glable,String gintroduce);

    /**
     * 通过gid修改商品信息
     */
    @Update("UPDATE goods SET gname=#{gname},gimage=#{gimage},gprices=#{gprices},glable=#{glable},gintroduce=#{gintroduce}  WHERE gid=#{gid}")
    void updateGoods(String gname,String gimage,String gprices,String glable,String gintroduce,int gid);

    /**
     * 通过gid查找商品
     */
    @Select("SELECT\n" +
            "\tgoods.*\n" +
            "FROM\n" +
            "\tgoods\n" +
            "WHERE\n" +
            "\tgoods.gid = #{gid}")
    Goods findGoodsById(int gid);

    /**
     * 通过sid查找所有商品
     */
    @Select("SELECT\n" +
            "\t*, \n" +
            "\tgoods.*\n" +
            "FROM\n" +
            "\tgoods\n" +
            "WHERE\n" +
            "\tgoods.sid = #{sid}")
    ArrayList<Goods> findAllGooodsBySid(int sid);


}
