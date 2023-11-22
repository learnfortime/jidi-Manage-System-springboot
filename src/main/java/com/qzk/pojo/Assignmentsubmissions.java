package com.qzk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignmentsubmissions {
    private Integer submission_id;

    private Integer student_id;

    private Integer teacher_id;

    private String assignment_name;

    private Date submission_date;

    private Integer grade;

    private String submission_content;

}