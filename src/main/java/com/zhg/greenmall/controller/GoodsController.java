package com.zhg.greenmall.controller;

import com.zhg.greenmall.entity.Goods;
import com.zhg.greenmall.service.GoodsService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/goods")
public class GoodsController {


    @Resource
    GoodsService goodsService;

    @PostMapping("test")
    Goods test(){
        System.out.println("test");
        System.out.println(goodsService.findGoodsById(9).toString());
        return goodsService.findGoodsById(9);
    }

    @PostMapping("add")
    Boolean addGoods(@RequestBody Goods goods){
        System.out.println(goods.toString());
        return goodsService.addStore(goods.getSid(),goods.getGname(),goods.getGimage(),goods.getGprices(),goods.getGlable(),goods.getGintroduce());
    }

    /**
     * 查询所有商品
     */

}
