package com.zhg.greenmall.controller;

import com.zhg.greenmall.entity.GoodsShow;
import com.zhg.greenmall.entity.Store;
import com.zhg.greenmall.service.StoreService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/store")
public class StoreController {

    @Resource
    StoreService storeService;

    /**
     * 修改店铺状态
     */
    @PostMapping("/updateStoreState")
    public Boolean updateStoreState(@RequestBody Store store){
        return storeService.updateStoreState(store.getStore_state(),store.getStore_id());
    }

    /**
     * 修改密码
     *
     */
    @PostMapping("/updatePassword")
    public Boolean updatePassword(@RequestBody Store store){
        return storeService.updatePassword(store.getStore_password(),store.getStore_id());
    }


    /**
     * 查询店铺信息
     */
   @PostMapping("/findAllStore")
   public List<GoodsShow> findAllStore(){
       return storeService.findAllStore();
   }

    /**
     * 查询所有店铺销量
     */
    @PostMapping("findHotStore")
    public List<Store> findHotStore() {
        return storeService.findHotStore();
    }

    /**
     * 通过sid查找
     *
     */
    @PostMapping("/findOneBySid")
    public Store findOneBySid(@RequestBody Store store){
        System.out.println("通过sid查找用户信息"+store.getStore_id());
        System.out.println(storeService.findOneById(store.getStore_id()));
        return storeService.findOneById(store.getStore_id());
    }

    /**
     * 商户注册
     *  */
    @PostMapping("/add")
    Boolean addStore(@RequestBody Store store){
        System.out.println(store);
        return storeService.addStore(store.getStore_time(),store.getStore_name(),store.getStore_username(),store.getStore_password(),store.getStore_state());

    }


    /**
     *商户登录
     */
    @PostMapping("/login")
    Store findStore(@RequestBody Store store){
        System.out.println("login"+store.getStore_username());
        System.out.println(storeService.findOneByNameAndPass(store.getStore_username(),store.getStore_password()));
        return storeService.findOneByNameAndPass(store.getStore_username(),store.getStore_password());
    }

}
