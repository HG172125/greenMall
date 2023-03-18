package com.zhg.greenmall.mapper;

import com.zhg.greenmall.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    /**
     * 登录查询
     */
    @Select("SELECT\n" +
            "\tadmin.admin_name, \n" +
            "\tadmin.admin_password\n" +
            "FROM\n" +
            "\tadmin\n" +
            "WHERE\n" +
            "\tadmin.admin_name = #{admin_name} AND\n" +
            "\tadmin.admin_password = #{admin_password}")
    Admin findAdminByNameAndPass(String admin_name,String admin_password);

}
