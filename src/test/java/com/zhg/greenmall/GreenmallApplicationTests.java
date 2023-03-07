package com.zhg.greenmall;

import com.zhg.greenmall.controller.StoreController;
import com.zhg.greenmall.entity.Store;
import com.zhg.greenmall.entity.User;
import com.zhg.greenmall.mapper.StoreMapper;
import com.zhg.greenmall.mapper.UserMapper;
import com.zhg.greenmall.service.StoreService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.security.cert.CertStoreSpi;

@SpringBootTest
class GreenmallApplicationTests {
    @Resource
    StoreService storeService;
    User user;
    Test test;

    @Test
    void test01(){
        storeService.addStore("1234","1234","1234","1234");
        System.out.println(storeService.findOneByName("1234"));
    }

    @Test
    void test02(){

    }


}
