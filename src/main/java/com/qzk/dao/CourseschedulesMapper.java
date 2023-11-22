package com.qzk.dao;

import com.qzk.pojo.Courseschedules;
import java.util.List;

public interface CourseschedulesMapper {
    int deleteByPrimaryKey(Integer schedule_id);

    int insert(Courseschedules record);

    Courseschedules selectByPrimaryKey(Integer schedule_id);

    List<Courseschedules> selectAll();

    int updateByPrimaryKey(Courseschedules record);
}