package com.qzk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teachers {
    private Integer teacher_id;

    private String teacher_name;

    private String email;

    private String phoneNumber;

    private String expertise;

}