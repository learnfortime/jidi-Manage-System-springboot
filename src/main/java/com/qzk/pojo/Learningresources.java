package com.qzk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Learningresources {
    private Integer resource_id;

    private Integer course_id;

    private String resource_type;

    private String resource_name;

    private String resource_content;

}