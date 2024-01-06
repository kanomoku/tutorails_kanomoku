package com.zhangziwa.practisesvr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String username;
    private String password;
    private int age;
    private int height;
    private String gender;
    private int classId;
    private boolean logicDelete;
}