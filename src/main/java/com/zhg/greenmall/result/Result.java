package com.zhg.greenmall.result;

import lombok.Data;

import java.util.HashMap;

@Data
public class Result {
    private static final String CODE = "code";
    private static final String MESSAGE = "msg";
    private static final String DATA = "data";

    private String code;
    private String msg;
    private Object data;

    public HashMap<String,Object> getResult(String code,String msg, Object data){
        this.code=code;
        this.msg=msg;
        this.data=data;
        HashMap<String,Object> map = new HashMap<>();
        map.put(CODE,code);
        map.put(MESSAGE,msg);
        map.put(DATA,data);
        return map;
    }
}
