package com.zhg.greenmall.service.serviceImpl;

import com.zhg.greenmall.entity.GoodsShow;
import com.zhg.greenmall.entity.Store;
import com.zhg.greenmall.mapper.StoreMapper;
import com.zhg.greenmall.service.StoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Resource
    StoreMapper storeMapper;

    @Override
    public Boolean updateStoreState(String store_state, int store_id) {
        System.out.println("修改店铺状态："+store_id+store_state);
        try {
            storeMapper.updateStoreState(store_state,store_id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean updatePassword(String store_password, int store_id) {
        try {
            storeMapper.updatePassword(store_password,store_id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * 查询店铺信息
     */
    @Override
    public List<GoodsShow> findAllStore() {
        return storeMapper.findAllStore();
    }

    /**
     * sid查找
     */
    @Override
    public Store findOneById(int store_id) {
        return storeMapper.findOneById(store_id);
    }


    @Override
    public List<Store> findHotStore() {
        return storeMapper.findHotStore();
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
