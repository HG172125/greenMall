package com.zhg.greenmall;

import com.zhg.greenmall.controller.StoreController;
import com.zhg.greenmall.entity.Store;
import com.zhg.greenmall.entity.User;
import com.zhg.greenmall.mapper.StoreMapper;
import com.zhg.greenmall.mapper.UserMapper;
import com.zhg.greenmall.service.GoodsService;
import com.zhg.greenmall.service.StoreService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.security.cert.CertStoreSpi;

@SpringBootTest
class GreenmallApplicationTests {
    @Resource
    StoreService storeService;
    @Resource
    GoodsService goodsService;

    @Test
    void test01(){

        System.out.println(storeService.findONeByNameAndPass("123","123"));
    }

    @Test
    void test02(){

        System.out.println(goodsService.addStore(123,"123","123","123","123","123"));
    }


}
