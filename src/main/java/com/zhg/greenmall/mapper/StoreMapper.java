package com.zhg.greenmall.mapper;

import com.zhg.greenmall.entity.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StoreMapper {
    /**
     *添加商户
     */
    @Insert("insert into store(sname,susername,suserphone,spassword) VALUES(#{sname},#{susername},#{suserphone},#{spassword})")
    void addStore(String sname,String susername ,String suserphone,String spassword);

    /**
     * 姓名查找
     */
    @Select("SELECT\n" +
            "\tstore.*\n" +
            "FROM\n" +
            "\tstore\n" +
            "WHERE\n" +
            "\tstore.sname = #{sname}")
    Store findOneByName(String name);

    /**
     * 登录查询
     */

    @Select("SELECT\n" +
            "\tstore.*\n" +
            "FROM\n" +
            "\tstore\n" +
            "WHERE\n" +
            "\tstore.sname = #{sname} AND\n" +
            "\tstore.spassword = #{spassword}")
    Store findONeByNameAndPass(String sname,String spassword);

}
