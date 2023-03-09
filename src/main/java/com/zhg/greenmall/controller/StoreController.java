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

    @PostMapping("/add")
    Boolean addStore(@RequestBody Store store){
        System.out.println(store);
        return storeService.addStore(store.getSname(),store.getSusername(),store.getSuserphone(),store.getSpassword());
    }

    @PostMapping("/login")
    Store findStore(@RequestBody Store store){
        System.out.println("login"+store.getSusername());
        return storeService.findONeByNameAndPass(store.getSusername(),store.getSpassword());
    }

}
