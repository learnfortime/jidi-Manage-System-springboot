package com.qzk.dao;

import com.qzk.pojo.Onlinelearning;
import java.util.List;

public interface OnlinelearningMapper {
    int deleteByPrimaryKey(Integer learning_id);

    int insert(Onlinelearning record);

    Onlinelearning selectByPrimaryKey(Integer learning_id);

    List<Onlinelearning> selectAll();

    int updateByPrimaryKey(Onlinelearning record);
}