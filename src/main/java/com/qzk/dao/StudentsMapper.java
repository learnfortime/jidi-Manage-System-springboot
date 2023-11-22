package com.qzk.dao;

import com.qzk.pojo.Students;
import com.qzk.pojo.StudentsExtends;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentsMapper {
    int insert(Students record);

    int deleteByPrimaryKey(int id);

    int updateByPrimaryKey(Students students);

    StudentsExtends selectByPrimaryKey(int id);

    List<StudentsExtends> selectAll();
}