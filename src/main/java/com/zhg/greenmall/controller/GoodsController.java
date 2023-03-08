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
    String test( @RequestBody Goods goods){
        System.out.println(goods.toString());
        return goods.toString();
    }

    @PostMapping("add")
    Boolean addGoods(@RequestBody Goods goods){
        System.out.println(goods.toString());
        System.out.println(goodsService.addStore(goods.getSid(),goods.getGname(),goods.getGimage(),goods.getGprices(),goods.getGlable(),goods.getGintroduce()));
        return goodsService.addStore(goods.getSid(),goods.getGname(),goods.getGimage(),goods.getGprices(),goods.getGlable(),goods.getGintroduce());
    }
}
