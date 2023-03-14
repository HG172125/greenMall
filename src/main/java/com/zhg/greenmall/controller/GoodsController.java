package com.zhg.greenmall.controller;

import com.zhg.greenmall.entity.Goods;
import com.zhg.greenmall.entity.GoodsShow;
import com.zhg.greenmall.entity.Order;
import com.zhg.greenmall.entity.Store;
import com.zhg.greenmall.service.GoodsService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/goods")
public class GoodsController {


    @Resource
    GoodsService goodsService;

    /**
     * 查询销量前8商品 id name 销量
     */
    @PostMapping("/findgoodsNumberBysid")
    public List<Goods> findgoodsNumberBysid(@RequestBody Store store){
        System.out.println("查询热门商品销量"+store.getStore_id());
        return goodsService.findgoodsNumberBysid(store.getStore_id());
    }


    /**
     * 通过信息查找商品
     */
    @PostMapping("/select")
    List<Goods> findGoodsBySelect(@RequestBody Goods goods){
        System.out.println("查询--"+goods.getGoods_name());
        return goodsService.findGoodsBySelect(goods.getGoods_name());
    }

    /**
     * 查询水果商品
     */
    @PostMapping("/fruitGoods")
    List<Goods> findFruitGoods() {
        return goodsService.findFruitGoods();
    }

    /**
     * 查询蔬菜商品
     */
    @PostMapping("/vegetableGoods")
    List<Goods> findVegetableGoods(){
        return goodsService.findVegetableGoods();
    }

    /**
     * 修改商品库存
     */
    @PostMapping("updateStock")
    boolean updateStock(@RequestBody Goods goods){
        System.out.println("xiugai"+goods.getGoods_stock()+"-"+goods.getGoods_id());
       return goodsService.updateStock(goods.getGoods_stock(),goods.getGoods_id());
    }


    /**
     * 查询新添加商品
     */
    @PostMapping("newGoods")
    List<GoodsShow> findNewGoods() {
        return goodsService.findNewGoods();
    }

    /**
     * 查询热门商品
     */
    @PostMapping("/hotGoods")
    List<GoodsShow> findHotGoods(){
        return goodsService.findHotGoods();
    }


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
        System.out.println("name"+goods.getGoods_name());
        System.out.println("getGoods_prices"+goods.getGoods_prices());
        System.out.println("getGoods_stock"+goods.getGoods_stock());
        System.out.println("getGoods_lable"+goods.getGoods_lable());
        System.out.println("getGoods_description"+goods.getGoods_description());
        System.out.println("getGoods_id"+goods.getGoods_id());

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
