package com.qzk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teachers implements Serializable {
    private Integer teacher_id;

    private String teacher_name;

    private String email;

    private String phoneNumber;

    private String expertise;

    private String pwd;

    private List<Courses> listCourses;
}