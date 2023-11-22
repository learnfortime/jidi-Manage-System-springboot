package com.qzk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Courseschedules {
    private Integer schedule_id;

    private Integer course_id;

    private Integer teacher_id;

    private Date date;

    private Date time;

    private String location;

}