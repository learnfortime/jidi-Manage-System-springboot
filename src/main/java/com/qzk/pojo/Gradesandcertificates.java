package com.qzk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gradesandcertificates {
    private Integer gradeAndCertificateID;

    private Integer student_id;

    private Integer course_id;

    private Integer finalGrade;

    private String certificateURL;

}