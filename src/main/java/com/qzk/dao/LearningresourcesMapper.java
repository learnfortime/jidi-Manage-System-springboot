package com.qzk.dao;

import com.qzk.pojo.Learningresources;
import java.util.List;

public interface LearningresourcesMapper {
    int deleteByPrimaryKey(Integer resource_id);

    int insert(Learningresources record);

    Learningresources selectByPrimaryKey(Integer resource_id);

    List<Learningresources> selectAll();

    int updateByPrimaryKey(Learningresources record);
}