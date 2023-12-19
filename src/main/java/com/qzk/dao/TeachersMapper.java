package com.qzk.dao;

import com.qzk.pojo.Courses;
import com.qzk.pojo.Teachers;
import java.util.List;

public interface TeachersMapper {
    int insert(Teachers record);

    List<Teachers> selectAll();

    int update(Teachers teachers);

    Teachers selectByPrimaryKey(int teacher_id);
    int delete(int teacher_id);

    Teachers boolTeacher(Teachers teachers);

    int add(Teachers teachers);

    int addCource (int teacher_id,int course_ID);
}