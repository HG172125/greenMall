package com.zhg.greenmall.service;

import com.zhg.greenmall.entity.GoodsShow;
import com.zhg.greenmall.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> findWeeksOrder();

    /**
     * 查询所有订单状态
     */
   List<Order> findAllOrderState();

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

    List<GoodsShow> findAllOrderInfo();

    List<Order>findOrderByState(int store_id);

    List<GoodsShow> findYixiadanBsid(int sid);
    List<GoodsShow> findYiwanchengBsid(int sid);

    List<GoodsShow> findOrderbyYiwancheng(int user_id);
    List<GoodsShow> findOrderbyYifahuo(int user_id);
    List<GoodsShow> findOrderbyYixiadan(int user_id);

    /**
     * 通过id删除
     */
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
