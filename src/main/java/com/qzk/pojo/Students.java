package com.qzk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Students {
//    students
    private Integer student_id;

    private String student_name;

    private String email;

    private String phoneNumber;

    private Integer progress;

}