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
    @Insert("insert into store(store_name,store_username,store_password) VALUES(#{store_name},#{store_username},#{store_password})")
    void addStore(String store_name,String store_username,String store_password);

    /**
     * 姓名查找
     */
    @Select("SELECT\n" +
            "\tstore.*\n" +
            "FROM\n" +
            "\tstore\n" +
            "WHERE\n" +
            "\tstore.store_username = #{store_username}")
    Store findOneByName(String store_username);
    /**
     * sid查找
     */
    @Select("SELECT\n" +
            "\tstore.*\n" +
            "FROM\n" +
            "\tstore\n" +
            "WHERE\n" +
            "\tstore.store_id = #{store_id}")
    Store findOneById(int store_id);

    /**
     * 登录查询
     */
    @Select("SELECT\n" +
            "\tstore.*\n" +
            "FROM\n" +
            "\tstore\n" +
            "WHERE\n" +
            "\tstore.store_username = #{store_username} AND\n" +
            "\tstore.store_password = #{store_password}")
    Store findOneByNameAndPass(String store_username,String store_password);

}
