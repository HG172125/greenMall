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
    void test01(){
        System.out.println(userMapper.findUserByNameAndPassword("123","123"));
    }


}
