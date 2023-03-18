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

    /**
     * sid查找
     */
    @Override
    public Store findOneById(int store_id) {
        return storeMapper.findOneById(store_id);
    }


    @Override
    public boolean addStore(String store_name, String store_username, String store_password) {
      try {
          storeMapper.addStore(store_name,store_username,store_password);
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
    public Store findOneByNameAndPass(String susername, String pass) {
        return storeMapper.findOneByNameAndPass(susername,pass);
    }

}
