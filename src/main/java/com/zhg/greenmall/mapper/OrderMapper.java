package com.zhg.greenmall.mapper;

import com.zhg.greenmall.entity.GoodsShow;
import com.zhg.greenmall.entity.Order;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface OrderMapper {

    /**
     * 查询所有订单状态
     * */
    @Select("SELECT\n" +
            "\t`order`.order_id, \n" +
            "\t`user`.user_name, \n" +
            "\t`order`.order_state, \n" +
            "\tgoods.goods_name, \n" +
            "\tstore.store_name, \n" +
            "\tgoods.goods_photo, \n" +
            "\tgoods.goods_prices, \n" +
            "\t`order`.order_goodsnumber\n" +
            "FROM\n" +
            "\t`order`\n" +
            "\tINNER JOIN\n" +
            "\t`user`\n" +
            "\tON \n" +
            "\t\t`order`.user_id = `user`.user_id\n" +
            "\tINNER JOIN\n" +
            "\tgoods\n" +
            "\tON \n" +
            "\t\t`order`.goods_id = goods.goods_id\n" +
            "\tINNER JOIN\n" +
            "\tstore\n" +
            "\tON \n" +
            "\t\tgoods.store_id = store.store_id\n")
    List<GoodsShow> findAllOrderInfo();


    /**
     * 查询所有订单状态
     */
    @Select("SELECT\n" +
            "\tCOUNT(`order`.order_id) AS order_goodsnumber, \n" +
            "\t`order`.order_state\n" +
            "FROM\n" +
            "\t`order`\n" +
            "GROUP BY\n" +
            "\t`order`.order_state")
    List<Order> findAllOrderState();

    /**
     * 查询近七日订单
     */
    @Select("select d.date order_time, IFNULL(T.order_goodsnumber,0) order_goodsnumber from \n" +
            "(\n" +
            "    SELECT CURDATE() AS date\n" +
            "    UNION ALL\n" +
            "    SELECT DATE_SUB(CURDATE(), INTERVAL 1 DAY) AS date\n" +
            "    UNION ALL\n" +
            "    SELECT DATE_SUB(CURDATE(), INTERVAL 2 DAY) AS date\n" +
            "    UNION ALL\n" +
            "    SELECT DATE_SUB(CURDATE(), INTERVAL 3 DAY) AS date\n" +
            "    UNION ALL\n" +
            "    SELECT DATE_SUB(CURDATE(), INTERVAL 4 DAY) AS date\n" +
            "    UNION ALL\n" +
            "    SELECT DATE_SUB(CURDATE(), INTERVAL 5 DAY) AS date\n" +
            "    UNION ALL\n" +
            "    SELECT DATE_SUB(CURDATE(), INTERVAL 6 DAY) AS date\n" +
            ")  d\n" +
            "left join(\n" +
            "    select DATE_FORMAT(order_time,'%y-%m-%d') AS order_time , SUM(order_goodsnumber) as order_goodsnumber\n" +
            "    from `order`\n" +
            "    group by order_time\n" +
            ") T on T.order_time = d.date\n" +
            "GROUP BY d.date")
    List<Order> findWeeksOrder();


    /**
     * 查询今日订单
     */
    @Select("SELECT\n" +
            "\tCOUNT(`order`.order_id) AS number\n" +
            "FROM\n" +
            "\t`order`\n" +
            "WHERE\n" +
            "\tto_days(order_time) = to_days(now())")
    int daysOreder();
    /**
     * 查询月订单
     */
    @Select("SELECT\n" +
            "\tCOUNT(`order`.order_id) AS number\n" +
            "FROM\n" +
            "\t`order`\n" +
            "WHERE\n" +
            "\tDATE_SUB(CURDATE(),INTERVAL 30 DAY) <= DATE(order_time) AND\n" +
            "\t`order`.order_state <> '已加购'")
    int mouthOreder();
    /**
     * 查询年订单
     */
    @Select("SELECT\n" +
            "\tCOUNT(`order`.order_id) AS number\n" +
            "FROM\n" +
            "\t`order`\n" +
            "WHERE\n" +
            "\t`order`.order_state <> '已加购' ")
    int yearsOrder();


    /**
     * 查询所有下单
     */
    @Select("SELECT\n" +
            "\tCOUNT(`order`.order_id) AS order_goodsnumber\n" +
            "FROM\n" +
            "\t`order`\n" +
            "\tINNER JOIN\n" +
            "\tgoods\n" +
            "\tON \n" +
            "\t\t`order`.goods_id = goods.goods_id\n" +
            "WHERE\n" +
            "\tgoods.store_id = #{store_id}")
    Order findAllOrder(int store_id);

    /**
     * 查询今日下单
     */
    @Select("SELECT\n" +
            "\tCOUNT(`order`.order_id)  AS order_goodsnumber\n" +
            "FROM\n" +
            "\t`order`\n" +
            "\tINNER JOIN\n" +
            "\tgoods\n" +
            "\tON \n" +
            "\t\t`order`.goods_id = goods.goods_id\n" +
            "WHERE\n" +
            "\tgoods.store_id = #{store_id} AND\n" +
            "\tto_days(order_time) = to_days(now())")
    Order findTodaysOrder(int store_id);

    /**
 * 查询订单以状态分类
 */
@Select("SELECT\n" +
        "\tCOUNT(`order`.order_id) AS order_goodsnumber, \n" +
        "\t`order`.order_state\n" +
        "FROM\n" +
        "\t`order`\n" +
        "\tINNER JOIN\n" +
        "\tgoods\n" +
        "\tON \n" +
        "\t\t`order`.goods_id = goods.goods_id\n" +
        "WHERE\n" +
        "\tgoods.store_id = #{store_id}\n" +
        "GROUP BY\n" +
        "\t`order`.order_state")
 List<Order>findOrderByState( int store_id);


    /**
     * 通过id删除
     */
    @Delete("DELETE FROM `order` WHERE order_id=#{order_id}")
    void deleteOrderByOid(int order_id);

    /**
     * 商家查询已下单
     */
    @Select("SELECT\n" +
            "\t`order`.order_id, \n" +
            "\t`order`.order_state, \n" +
            "\tgoods.goods_id, \n" +
            "\tgoods.goods_name, \n" +
            "\tgoods.goods_photo, \n" +
            "\tgoods.goods_prices, \n" +
            "\tgoods.goods_stock, \n" +
            "\tgoods.goods_lable, \n" +
            "\tgoods.goods_description, \n" +
            "\t`order`.order_goodsnumber, \n" +
            "\t`user`.user_id, \n" +
            "\t`user`.user_name, \n" +
            "\t`user`.user_phone, \n" +
            "\t`user`.user_address\n" +
            "FROM\n" +
            "\tgoods\n" +
            "\tINNER JOIN\n" +
            "\t`order`\n" +
            "\tON \n" +
            "\t\tgoods.goods_id = `order`.goods_id\n" +
            "\tINNER JOIN\n" +
            "\t`user`\n" +
            "\tON \n" +
            "\t\t`order`.user_id = `user`.user_id\n" +
            "WHERE\n" +
            "\tgoods.store_id = #{store_id} AND\n" +
            "\t`order`.order_state = '已下单'\n" +
            "GROUP BY\n" +
            "\t`order`.order_id")
    List<GoodsShow> findYixiadanBsid(int store_id);
    @Select("SELECT\n" +
            "\t`order`.order_id, \n" +
            "\t`order`.order_state, \n" +
            "\tgoods.goods_id, \n" +
            "\tgoods.goods_name, \n" +
            "\tgoods.goods_photo, \n" +
            "\tgoods.goods_prices, \n" +
            "\tgoods.goods_stock, \n" +
            "\tgoods.goods_lable, \n" +
            "\tgoods.goods_description, \n" +
            "\t`order`.order_goodsnumber, \n" +
            "\t`user`.user_id, \n" +
            "\t`user`.user_name, \n" +
            "\t`user`.user_phone, \n" +
            "\t`user`.user_address\n" +
            "FROM\n" +
            "\tgoods\n" +
            "\tINNER JOIN\n" +
            "\t`order`\n" +
            "\tON \n" +
            "\t\tgoods.goods_id = `order`.goods_id\n" +
            "\tINNER JOIN\n" +
            "\t`user`\n" +
            "\tON \n" +
            "\t\t`order`.user_id = `user`.user_id\n" +
            "WHERE\n" +
            "\tgoods.store_id = #{store_id} AND\n" +
            "\t`order`.order_state = '已完成'\n" +
            "GROUP BY\n" +
            "\t`order`.order_id")
    List<GoodsShow> findYiwanchengBsid(int store_id);

    /**
     * 修改订单状态
     */
    @Update("UPDATE `order`  SET order_state=#{order_state} WHERE order_id=#{order_id}")
    void updateStock(String order_state,int order_id);


    /**
     * 添加订单
     */
    @Insert("insert into `order`" +
            "(user_id,goods_id,order_goodsnumber," +
            "order_time,order_state) " +
            "values (#{user_id},#{goods_id}," +
            "#{order_goodsnumber},#{order_time},#{order_state})")
    void addOrder(int user_id,int goods_id,int order_goodsnumber,
                  String order_time,String order_state);

    @Select("SELECT\n" +
            "\t`user`.user_phone, \n" +
            "\t`user`.user_address, \n" +
            "\t`order`.order_id, \n" +
            "\t`order`.order_goodsnumber, \n" +
            "\t`order`.order_state, \n" +
            "\tgoods.goods_name, \n" +
            "\tgoods.goods_prices, \n" +
            "\tstore.store_name\n" +
            "FROM\n" +
            "\t`order`\n" +
            "\tINNER JOIN\n" +
            "\t`user`\n" +
            "\tON \n" +
            "\t\t`order`.user_id = `user`.user_id\n" +
            "\tINNER JOIN\n" +
            "\tgoods\n" +
            "\tON \n" +
            "\t\tgoods.goods_id = `order`.goods_id\n" +
            "\tINNER JOIN\n" +
            "\tstore\n" +
            "\tON \n" +
            "\t\tgoods.store_id = store.store_id\n" +
            "WHERE\n" +
            "\t`order`.user_id = #{user_id} AND\n" +
            "\t`order`.order_state = '已完成' ORDER BY `order`.order_time DESC")
    List<GoodsShow> findOrderbyYiwancheng(int user_id);

    @Select("SELECT\n" +
            "\t`user`.user_phone, \n" +
            "\t`user`.user_address, \n" +
            "\t`order`.order_id, \n" +
            "\t`order`.order_goodsnumber, \n" +
            "\t`order`.order_state, \n" +
            "\tgoods.goods_name, \n" +
            "\tgoods.goods_prices, \n" +
            "\tstore.store_name\n" +
            "FROM\n" +
            "\t`order`\n" +
            "\tINNER JOIN\n" +
            "\t`user`\n" +
            "\tON \n" +
            "\t\t`order`.user_id = `user`.user_id\n" +
            "\tINNER JOIN\n" +
            "\tgoods\n" +
            "\tON \n" +
            "\t\tgoods.goods_id = `order`.goods_id\n" +
            "\tINNER JOIN\n" +
            "\tstore\n" +
            "\tON \n" +
            "\t\tgoods.store_id = store.store_id\n" +
            "WHERE\n" +
            "\t`order`.user_id = #{user_id} AND\n" +
            "\t`order`.order_state = '已发货' ORDER BY `order`.order_time DESC")
    List<GoodsShow> findOrderbyYifahuo(int user_id);

    /**
     *已下单order
     */
    @Select("SELECT\n" +
            "\t`user`.user_phone, \n" +
            "\t`user`.user_address, \n" +
            "\t`order`.order_id, \n" +
            "\t`order`.order_goodsnumber, \n" +
            "\t`order`.order_state, \n" +
            "\tgoods.goods_name, \n" +
            "\tgoods.goods_prices, \n" +
            "\tstore.store_name\n" +
            "FROM\n" +
            "\t`order`\n" +
            "\tINNER JOIN\n" +
            "\t`user`\n" +
            "\tON \n" +
            "\t\t`order`.user_id = `user`.user_id\n" +
            "\tINNER JOIN\n" +
            "\tgoods\n" +
            "\tON \n" +
            "\t\tgoods.goods_id = `order`.goods_id\n" +
            "\tINNER JOIN\n" +
            "\tstore\n" +
            "\tON \n" +
            "\t\tgoods.store_id = store.store_id\n" +
            "WHERE\n" +
            "\t`order`.user_id = #{user_id} AND\n" +
            "\t`order`.order_state = '已下单' ORDER BY `order`.order_time DESC")
    List<GoodsShow> findOrderbyYixiadan(int user_id);

    /**
     * 根据用户id查询已加购订单信息
     */
    @Select("SELECT\n" +
            "\t`order`.goods_id, \n" +
            "\t`order`.order_goodsnumber, \n" +
            "\t`order`.order_id, \n" +
            "\t`order`.user_id, \n" +
            "\tgoods.goods_name, \n" +
            "\tgoods.goods_photo, \n" +
            "\tgoods.goods_prices, \n" +
            "\tgoods.goods_description, \n" +
            "\tgoods.goods_stock, \n" +
            "\t`order`.order_time\n" +
            "FROM\n" +
            "\tgoods\n" +
            "\tINNER JOIN\n" +
            "\t`order`\n" +
            "\tON \n" +
            "\t\tgoods.goods_id = `order`.goods_id\n" +
            "WHERE\n" +
            "\t`order`.user_id = #{user_id} AND\n" +
            "\t`order`.order_state = '已加购'\n" +
            "ORDER BY\n" +
            "\t`order`.order_time DESC")
    List<GoodsShow> findOrderbyUidCart(int user_id);

}
