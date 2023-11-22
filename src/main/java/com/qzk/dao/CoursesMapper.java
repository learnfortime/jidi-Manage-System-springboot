package com.qzk.dao;

import com.qzk.pojo.Courses;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoursesMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(Courses record);

    Courses selectByPrimaryKey(Integer courseId);

    List<Courses> selectAll();

    int updateByPrimaryKey(Courses record);
}