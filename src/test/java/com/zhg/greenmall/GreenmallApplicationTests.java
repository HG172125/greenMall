package com.zhg.greenmall;

import com.zhg.greenmall.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class GreenmallApplicationTests {

    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper.findUserByName("test1"));
    }


    @Test
    void test01(){
        if(userMapper.findUserByName("test1") != null){
            System.out.println("用户名重复！！");
        } else{
            userMapper.addUser("test1","test1");
        }
    }


}
