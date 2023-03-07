package com.zhg.greenmall.service.serviceImpl;

import com.zhg.greenmall.entity.Store;
import com.zhg.greenmall.mapper.StoreMapper;
import com.zhg.greenmall.service.StoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StoreServiceImpl implements StoreService {

    @Resource
    StoreMapper storeMapper;

    @Override
    public boolean addStore(String sname,String susername ,String suserphone,String spassword) {
        System.out.println(sname);
        try {
            storeMapper.addStore(sname, susername, suserphone, spassword);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Store findOneByName(String name) {
        return storeMapper.findOneByName(name);
    }

    @Override
    public Store findONeByNameAndPass(String name, String pass) {
        return storeMapper.findONeByNameAndPass(name,pass);
    }

}
