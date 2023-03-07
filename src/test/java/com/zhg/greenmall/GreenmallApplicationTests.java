package com.zhg.greenmall;

import com.zhg.greenmall.entity.Store;
import com.zhg.greenmall.entity.User;
import com.zhg.greenmall.mapper.StoreMapper;
import com.zhg.greenmall.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.security.cert.CertStoreSpi;

@SpringBootTest
class GreenmallApplicationTests {
    @Resource
    StoreMapper storeMapper;

    @Test
    void test01(){
        Store store = new Store();
        store.setId(1);
        store.setSname("123");
        store.setSusername("123");
        store.setSuserphone("123");
        store.setSuserphone("123");
        System.out.println(storeMapper.findOneBySusername("store"));
        System.out.println("m");
    }

    @Test
    void test02(){

    }


}
