package com.qzk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentsExtends {
    private Integer student_id;

    private String student_name;

    private String email;

    private String phoneNumber;

    private Integer progress;


    //onlinelearning
    private Integer learning_id;

    private Integer course_id;

    private String video_url;

    private Integer quiz_Results;
    //Assignmentsubmissions
    private Integer submission_id;

    private Integer teacher_id;

    private String assignment_name;

    private Date submission_date;

    private Integer grade;

    private String submission_content;
    //    gradesandcertificates
    private List<Gradesandcertificates> gradesandcertificates;

    public List<Gradesandcertificates> getGradesAndCertificates() {
        return gradesandcertificates;
    }

    public void setGradesAndCertificates(List<Gradesandcertificates> gradesAndCertificates) {
        this.gradesandcertificates = gradesAndCertificates;
    }
}
