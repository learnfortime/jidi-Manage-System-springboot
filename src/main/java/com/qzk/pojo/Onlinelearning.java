package com.qzk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Onlinelearning {
    private Integer learning_id;

    private Integer student_id;

    private Integer course_id;

    private String video_url;

    private Integer quiz_Results;

    }