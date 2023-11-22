package com.qzk.dao;

import com.qzk.pojo.Assignmentsubmissions;
import java.util.List;

public interface AssignmentsubmissionsMapper {
    int deleteByPrimaryKey(Integer submission_id);

    int insert(Assignmentsubmissions record);

    Assignmentsubmissions selectByPrimaryKey(Integer submission_id);

    List<Assignmentsubmissions> selectAll();

    int updateByPrimaryKey(Assignmentsubmissions record);
}