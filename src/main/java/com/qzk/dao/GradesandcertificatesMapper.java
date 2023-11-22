package com.qzk.dao;

import com.qzk.pojo.Gradesandcertificates;
import java.util.List;

public interface GradesandcertificatesMapper {
    int deleteByPrimaryKey(Integer gradeAndCertificateID);

    int insert(Gradesandcertificates record);

    Gradesandcertificates selectByPrimaryKey(Integer gradeAndCertificateID);

    List<Gradesandcertificates> selectAll();

    int updateByPrimaryKey(Gradesandcertificates record);
}