package com.zhg.greenmall.controller;

import com.zhg.greenmall.entity.Goods;
import com.zhg.greenmall.service.GoodsService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/goods")
public class GoodsController {


    @Resource
    GoodsService goodsService;


    /**
     * 通过gid删除商品信息
     */
    @PostMapping("delete")
    boolean deleteGoods(@RequestBody Goods goods){
        System.out.println("gid deleteGoods");
        return goodsService.deleteGoodsByGid(goods.getGoods_id());
    }


    /**
     * 通过gid修改商品信息
     */
    @PostMapping("/update")
    boolean updateGoods(@RequestBody Goods goods){
        System.out.println("EditeGoods");
        return goodsService.updateGoods(goods.getGoods_name(),goods.getGoods_photo(),goods.getGoods_prices(),
                goods.getGoods_stock(),goods.getGoods_lable(),goods.getGoods_description(),goods.getGoods_id());
    }

    /**
     * 查询所有商品
     */
    @PostMapping ("/findall")
    ArrayList<Goods> findAllGoods(@RequestBody Goods goods){
        System.out.println("得到数据"+goods.getStore_id());
        System.out.println("findall");
        System.out.println(goodsService.findAllGooodsBySid(goods.getStore_id()).toString());
        return goodsService.findAllGooodsBySid(goods.getStore_id());
    }

    /**
     *添加商品
     */
    @PostMapping("/add")
    Boolean addGoods(@RequestBody Goods goods){
        System.out.println("添加goods"+goods.toString());
        return goodsService.addStore(goods.getStore_id(),goods.getGoods_time(),goods.getGoods_name(),goods.getGoods_photo(),goods.getGoods_prices(),goods.getGoods_stock(),goods.getGoods_lable(),goods.getGoods_description());
    }




}
