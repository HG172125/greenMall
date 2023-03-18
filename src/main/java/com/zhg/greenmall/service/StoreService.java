package com.zhg.greenmall.service;

import com.zhg.greenmall.entity.Store;
import org.apache.ibatis.annotations.Select;

public interface StoreService {
    boolean addStore(String store_name,String store_username,String store_password);
    Store findOneByName(String store_username);
    Store findOneByNameAndPass(String store_username,String store_password);
    /**
     * sid查找
     */
    Store findOneById(int store_id);

}
