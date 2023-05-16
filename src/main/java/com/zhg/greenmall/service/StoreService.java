package com.zhg.greenmall.service;
import com.zhg.greenmall.entity.GoodsShow;
import com.zhg.greenmall.entity.Store;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StoreService {

    Boolean updateStoreState(String store_state,int store_id);

    /**
     * 修改密码
     */
    Boolean updatePassword(String store_password,int store_id);

    /**
     * 查询店铺信息
     */
    List<GoodsShow> findAllStore();

    List<Store> findHotStore();
    boolean addStore(String store_time,String store_name,String store_username,String store_password,String store_state);
    Store findOneByName(String store_username);
    Store findOneByNameAndPass(String store_username,String store_password);
    /**
     * sid查找
     */
    Store findOneById(int store_id);

}
