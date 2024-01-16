package com.zhangziwa.practisesvr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Integer height;
    private String gender;
    private Integer classId;
    private Boolean isDelete;
}