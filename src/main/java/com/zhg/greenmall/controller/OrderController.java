package com.zhg.greenmall.controller;

import com.zhg.greenmall.entity.GoodsShow;
import com.zhg.greenmall.entity.Order;
import com.zhg.greenmall.entity.Store;
import com.zhg.greenmall.entity.User;
import com.zhg.greenmall.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;

    /**
     * 查询所有下单
     */
    @PostMapping("findAllOrder")
    public Order findAllOrder( @RequestBody Store store) {
        System.out.println("查询storeid"+store.getStore_id());
        return orderService.findAllOrder(store.getStore_id());
    }
    /**
     * 查询今日下单
     */
    @PostMapping("findTodaysOrder")
    public Order findTodaysOrder( @RequestBody Store store) {
        System.out.println("查询storeid"+store.getStore_id());
        return orderService.findTodaysOrder(store.getStore_id());
    }

    /**
     *  查询订单数量byState
     */
    @PostMapping("/findState")
    List<Order>findOrderByState(@RequestBody Store store) {

        System.out.println("cahxun stste");
        System.out.println(store.getStore_id());
        return orderService.findOrderByState(store.getStore_id());
    }

    /**
     * 用户查询
     */
    @PostMapping("/yixiadan")
    List<GoodsShow> findYixiadan(@RequestBody User user){
        return orderService.findOrderbyYixiadan(user.getUser_id());
    }
    @PostMapping("/yifahuo")
    List<GoodsShow> findYifahuo(@RequestBody User user){
        return orderService.findOrderbyYifahuo(user.getUser_id());
    }
    @PostMapping("/yiwancheng")
    List<GoodsShow> findYiwancheng(@RequestBody User user){
        return orderService.findOrderbyYiwancheng(user.getUser_id());
    }


    /**
     * 商家查询
     */
    @PostMapping("findYixiadanBsid")
    List<GoodsShow> findYixiadanBsid(@RequestBody Order order){
        System.out.println(order.getOrder_id()+"查询已下单");
       return orderService.findYixiadanBsid(order.getOrder_id());
    }
    @PostMapping("findYiwanchengBsid")
    List<GoodsShow> findYiwanchengBsid(@RequestBody Order order){
        System.out.println(order.getOrder_id()+"查询已完成");
      return   orderService.findYiwanchengBsid(order.getOrder_id());
    }




    /**
     * 通过oid删除商品
     */
    @PostMapping("/deleteOrderBid")
    Boolean deleteOrderByid(@RequestBody Order order){
        System.out.println("删除订单+"+order.getOrder_id());
       return orderService.deleteOrderByOid(order.getOrder_id());
    }

    @PostMapping("findCart")
    List<GoodsShow> findCart(@RequestBody User user){
        System.out.println("查询购物车"+user.getUser_id());
        return orderService.findOrderbyUidCart(user.getUser_id());
    }

    @PostMapping("/insert")
    Boolean addOrder(@RequestBody Order order){
        System.out.println("添加订单"+order);
        return orderService.addOrder(order.getUser_id(),order.getGoods_id(),order.getOrder_goodsnumber(),order.getOrder_time(),order.getOrder_state());

    }

    /**
     * 修改订单状态
     */
    @PostMapping("/updateState")
    Boolean updateState(@RequestBody Order order){
        System.out.println("修改订单"+order.getOrder_id()+order.getOrder_state());
        return orderService.updateStock(order.getOrder_state(),order.getOrder_id());
    }

}
