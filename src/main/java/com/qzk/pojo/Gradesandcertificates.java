package com.qzk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gradesandcertificates implements Serializable {
    private Integer gradeAndCertificateID;

//    private Integer student_id;
//
    private Integer course_id;

    private Integer FinalGrade;

    private String certificateURL;

    private List<Students> studentsList;

}