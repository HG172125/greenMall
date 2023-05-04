package com.zhg.greenmall.mapper;

import com.zhg.greenmall.entity.GoodsShow;
import com.zhg.greenmall.entity.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StoreMapper {

    /**
     * 修改店铺状态
     */
    @Update("UPDATE `store`  SET store_state=#{store_state} WHERE store_id=#{store_id}")
    void updateStoreState(String store_state,int store_id);

    /**
     * 修改密码
     */
    @Update("UPDATE `store`  SET store_password=#{store_password} WHERE store_id=#{store_id}")
    void updatePassword(String store_password,int store_id);

    /**
     * 查询店铺信息
     */
    @Select("SELECT\n" +
            "\tstore.store_id, \n" +
            "\tstore.store_time, \n" +
            "\tstore.store_name, \n" +
            "\tstore.store_username, \n" +
            "\tstore.store_password, \n" +
            "\tstore.store_state, \n" +
            "\tCOUNT(goods.goods_id) AS store_number\n" +
            "FROM\n" +
            "\tstore\n" +
            "\tINNER JOIN\n" +
            "\tgoods\n" +
            "\tON \n" +
            "\t\tstore.store_id = goods.store_id\n" +
            "GROUP BY\n" +
            "\tstore.store_id")
    List<GoodsShow> findAllStore();

    /**
     * 查询所有店铺销量
     */
    @Select("SELECT\n" +
            "\tstore.store_name, \n" +
            "\tSUM(`order`.order_goodsnumber) AS store_state\n" +
            "FROM\n" +
            "\tstore\n" +
            "\tINNER JOIN\n" +
            "\tgoods\n" +
            "\tON \n" +
            "\t\tstore.store_id = goods.store_id\n" +
            "\tINNER JOIN\n" +
            "\t`order`\n" +
            "\tON \n" +
            "\t\t`order`.goods_id = goods.goods_id\n" +
            "GROUP BY\n" +
            "\tstore.store_id\n" +
            "ORDER BY\n" +
            "\tSUM(`order`.order_goodsnumber) DESC LIMIT 8")
    List<Store> findHotStore();


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
            "\tstore.store_password = #{store_password} AND" +
            "\t`store`.store_state <> '禁用'")
    Store findOneByNameAndPass(String store_username,String store_password);

}
