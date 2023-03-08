package com.zhg.greenmall.mapper;

import com.zhg.greenmall.entity.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GoodsMapper {


    /**
     * 添加商品
     */
    @Insert("insert into goods(sid,gname,gimage,gprices,glable,gintroduce) VALUES(#{sid},#{gname},#{gimage},#{gprices},#{glable},#{gintroduce})")
    void addStore(int sid,String gname,String gimage ,String gprices,String glable,String gintroduce);

    /**
     * 通过gid查找商品
     */
    @Select("SELECT\n" +
            "\tgoods.*\n" +
            "FROM\n" +
            "\tgoods\n" +
            "WHERE\n" +
            "\tgoods.gid = #{gid}")
    Goods findGoodsById(int sid);

}
