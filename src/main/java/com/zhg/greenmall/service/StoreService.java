package com.zhg.greenmall.service;

import com.zhg.greenmall.entity.Store;

public interface StoreService {
    boolean addStore(String sname,String susername ,String suserphone,String spassword);
    Store findOneByName(String name);
}
