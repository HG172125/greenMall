package com.zhg.greenmall.controller;

import com.zhg.greenmall.entity.Store;
import com.zhg.greenmall.service.StoreService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/store")
public class StoreController {

    @Resource
    StoreService storeService;

    @GetMapping("/test")
    String test(){
      return "tett";
    }


    /**
     * 商户注册
     *  */
    @PostMapping("/add")
    Boolean addStore(@RequestBody Store store){
        System.out.println(store);
        return storeService.addStore(store.getStore_name(),store.getStore_username(),store.getStore_password());

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
