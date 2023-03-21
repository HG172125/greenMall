package com.zhg.greenmall.service;

import com.zhg.greenmall.entity.GoodsShow;
import com.zhg.greenmall.entity.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrderService {
    List<Order> findWeeksOrder();

    /**
     * 查询今日订单
     */
    int daysOreder();
    /**
     * 查询月订单
     */
    int mouthOreder();
    /**
     * 查询年订单
     */
    int yearsOrder();


    /**
     * 查询所有下单
     */
    Order findAllOrder(int store_id);
    /**
     * 查询今日下单
     */
    Order findTodaysOrder(int store_id);

    List<Order>findOrderByState(int store_id);

    List<GoodsShow> findYixiadanBsid(int sid);
    List<GoodsShow> findYiwanchengBsid(int sid);

    List<GoodsShow> findOrderbyYiwancheng(int user_id);
    List<GoodsShow> findOrderbyYifahuo(int user_id);
    List<GoodsShow> findOrderbyYixiadan(int user_id);

    /**
     * 通过gid删除商品
     */
    @Delete("DELETE FROM `order` WHERE goods_id=#{order_id}")
    Boolean deleteOrderByOid(int order_id);

    /**
     * 添加订单
     */
    boolean addOrder(int user_id,int goods_id,int order_goodsnumber,String order_time,String order_state);
    List<GoodsShow> findOrderbyUidCart(int user_id);
    /**
     * 修改订单状态
     */
    boolean updateStock(String order_state,int order_id);

}
