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
        return goodsService.deleteGoodsByGid(goods.getGid());
    }


    /**
     * 通过gid修改商品信息
     */
    @PostMapping("/update")
    boolean updateGoods(@RequestBody Goods goods){
        System.out.println("EditeGoods");
        return goodsService.updateGoods(goods.getGname(),goods.getGimage(),goods.getGprices(),goods.getGlable(),goods.getGintroduce(),goods.getGid());
    }

    /**
     * 查询所有商品
     */
    @PostMapping ("/findall")
    ArrayList<Goods> findAllGoods(@RequestBody Goods goods){
        System.out.println("得到数据"+goods.getSid());
        System.out.println("findall");
        System.out.println(goodsService.findAllGooodsBySid(goods.getSid()).toString());
        return goodsService.findAllGooodsBySid(goods.getSid());
    }

    @PostMapping("/add")
    Boolean addGoods(@RequestBody Goods goods){
        System.out.println(goods.toString());
        return goodsService.addStore(goods.getSid(),goods.getGname(),goods.getGimage(),goods.getGprices(),goods.getGlable(),goods.getGintroduce());
    }




}
