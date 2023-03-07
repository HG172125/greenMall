package com.zhg.greenmall.controller;

import com.zhg.greenmall.entity.Store;
import com.zhg.greenmall.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@CrossOrigin
@RequestMapping("/store")
public class StoreController {

    @Resource
    StoreService storeService;

    @GetMapping("/test")
    String test(Store store){
       if (storeService.addStore(store.getSname(),store.getSusername(),store.getSuserphone(),store.getSpassword()))
       {
           return "true";
       }else {
           return "false";
       }
    }

    @PostMapping("/add")
    Boolean addStore(Store store){
        return storeService.addStore(store.getSname(),store.getSusername(),store.getSuserphone(),store.getSpassword());
    }

}
