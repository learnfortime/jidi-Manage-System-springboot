package com.qzk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.soap.Text;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Courses implements Serializable {
    private Integer course_ID;

    private String course_name;

    private String course_description;

    private String course_content;

    private List<Teachers> listTeacher;
}