package com.zhg.greenmall.service.serviceImpl;

import com.zhg.greenmall.entity.GoodsShow;
import com.zhg.greenmall.entity.Order;
import com.zhg.greenmall.mapper.OrderMapper;
import com.zhg.greenmall.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper orderMapper;



    @Override
    public List<Order> findWeeksOrder() {
        return orderMapper.findWeeksOrder();
    }

    @Override
    public List<Order> findAllOrderState() {
        return orderMapper.findAllOrderState();
    }

    @Override
    public int daysOreder() {
        return orderMapper.daysOreder();
    }

    @Override
    public int mouthOreder() {
        return orderMapper.mouthOreder();
    }

    @Override
    public int yearsOrder() {
        return orderMapper.yearsOrder();
    }

    /**
     * 查询所有下单
     */

    @Override
    public Order findAllOrder(int store_id) {

      return   orderMapper.findAllOrder(store_id);
    }


    /**
     * 查询今日下单
     */
    @Override
    public Order findTodaysOrder(int store_id) {
        return orderMapper.findTodaysOrder(store_id);
    }



    @Override
    public List<GoodsShow> findAllOrderInfo() {
        return orderMapper.findAllOrderInfo();
    }


    @Override
    public List<Order> findOrderByState(int store_id) {
        return orderMapper.findOrderByState(store_id);
    }

    @Override
    public List<GoodsShow> findYixiadanBsid(int sid) {
        return orderMapper.findYixiadanBsid(sid);
    }

    @Override
    public List<GoodsShow> findYiwanchengBsid(int sid) {
        return orderMapper.findYiwanchengBsid(sid);
    }

    @Override
    public List<GoodsShow> findOrderbyYiwancheng(int user_id) {
        return orderMapper.findOrderbyYiwancheng(user_id);
    }

    @Override
    public List<GoodsShow> findOrderbyYifahuo(int user_id) {
        return orderMapper.findOrderbyYifahuo(user_id);
    }

    @Override
    public List<GoodsShow> findOrderbyYixiadan(int user_id) {
        return orderMapper.findOrderbyYixiadan(user_id);
    }

    /**
     * 通过oid删除
     */
    @Override
    public Boolean deleteOrderByOid(int order_id) {
        try {
            orderMapper.deleteOrderByOid(order_id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean addOrder(int user_id,int goods_id,int order_goodsnumber,String order_time,String order_state) {
        try {
            orderMapper.addOrder(user_id,goods_id,order_goodsnumber,order_time,order_state);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public List<GoodsShow> findOrderbyUidCart(int user_id) {
        return orderMapper.findOrderbyUidCart(user_id);
    }
    /**
     * 修改订单状态
     */
    @Override
    public boolean updateStock(String order_state, int order_id) {
        try {
            orderMapper.updateStock(order_state,order_id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
