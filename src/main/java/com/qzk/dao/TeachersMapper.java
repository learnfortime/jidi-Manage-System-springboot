package com.qzk.dao;

import com.qzk.pojo.Teachers;
import java.util.List;

public interface TeachersMapper {
    int insert(Teachers record);

    List<Teachers> selectAll();
}