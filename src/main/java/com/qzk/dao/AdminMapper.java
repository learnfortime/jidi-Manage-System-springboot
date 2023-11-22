package com.qzk.dao;

import com.qzk.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    //判断Admin

    int boolAdmin(Admin admin);
}
