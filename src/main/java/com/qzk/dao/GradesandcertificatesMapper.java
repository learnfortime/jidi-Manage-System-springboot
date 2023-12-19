package com.qzk.dao;

import com.qzk.pojo.Gradesandcertificates;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradesandcertificatesMapper {
    int deleteByPrimaryKey(Integer gradeAndCertificateID);

    int insert(Gradesandcertificates record);

    Gradesandcertificates selectByPrimaryKey(Integer gradeAndCertificateID);

    List<Gradesandcertificates> selectAll();

    int updateByPrimaryKey(Gradesandcertificates record);
}