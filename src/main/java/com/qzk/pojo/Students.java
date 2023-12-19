package com.qzk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Students implements Serializable {
//    students
    private Integer student_id;

    private String student_name;

    private String email;

    private String phoneNumber;

    private Integer progress;

    private List<Gradesandcertificates> gradesandcertificates;

    public List<Gradesandcertificates> getGradesAndCertificates() {
        return gradesandcertificates;
    }

    public void setGradesAndCertificates(List<Gradesandcertificates> gradesAndCertificates) {
        this.gradesandcertificates = gradesAndCertificates;
    }

}