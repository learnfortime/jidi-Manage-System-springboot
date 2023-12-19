package com.qzk.dao;

import com.qzk.pojo.Students;
//import com.qzk.pojo.StudentsExtends;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentsMapper {
    int insert(Students record);

    int deleteByPrimaryKey(int id);

    int updateByPrimaryKey(Students students);

    List<Students> selectByPrimaryKey(Integer student_id,String student_name,String email,String phoneNumber,Integer progress,Integer gradeAndCertificateID,String certificateURL);

    int insertCertificate(Integer student_id,Integer gradeAndCertificateID);

    Students boolStudent(Students students);
    List<Students> selectAll();
}