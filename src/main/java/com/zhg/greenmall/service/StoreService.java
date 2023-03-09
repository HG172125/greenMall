package com.zhg.greenmall.service;

import com.zhg.greenmall.entity.Store;

public interface StoreService {
    boolean addStore(String store_name,String store_username,String store_password);
    Store findOneByName(String store_username);
    Store findOneByNameAndPass(String store_username,String store_password);
}
