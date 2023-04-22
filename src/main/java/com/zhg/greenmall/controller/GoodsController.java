package com.zhg.greenmall.controller;

import com.zhg.greenmall.entity.Goods;
import com.zhg.greenmall.entity.GoodsShow;
import com.zhg.greenmall.entity.Order;
import com.zhg.greenmall.entity.Store;
import com.zhg.greenmall.service.GoodsService;
import org.apache.ibatis.annotations.Select;
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
     * 修改商品状态
     */
    @PostMapping("/updateState")
    Boolean updateState(@RequestBody Goods goods){
        return goodsService.updateState(goods.getGoods_state(),goods.getGoods_id());
    }

    @PostMapping ("/findall")
    ArrayList<Goods> findAllGoods(@RequestBody Goods goods){
        return goodsService.findAllGooodsBySid(goods.getStore_id());
    }


    /**
     * 查询所有商品
     **/
    @PostMapping("findAllGoods")
    public List<GoodsShow> findAllGoods(){
        return goodsService.findAllGoods();
    }

    /**
     * 查询所有热门商品
     **/
    @PostMapping("/findAllHotGoods")
    public List<Goods> findAllHotGoods(){
        return goodsService.findAllHotGoods();
    }

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
        return goodsService.deleteGoodsByGid(goods.getGoods_id());
    }


    /**
     * 通过gid修改商品信息
     */
    @PostMapping("/update")
    boolean updateGoods(@RequestBody Goods goods){
        return goodsService.updateGoods(goods.getGoods_name(),
                goods.getGoods_photo(),goods.getGoods_prices(),
                goods.getGoods_stock(),goods.getGoods_lable(),
                goods.getGoods_description(),goods.getGoods_id());
    }


    /**
     *添加商品
     */
    @PostMapping("/add")
    Boolean addGoods(@RequestBody Goods goods){
        return goodsService.addStore(goods.getStore_id(),goods.getGoods_time(),goods.getGoods_name(),goods.getGoods_photo(),goods.getGoods_prices(),goods.getGoods_stock(),goods.getGoods_lable(),goods.getGoods_description());
    }




}
