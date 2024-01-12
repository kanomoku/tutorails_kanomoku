package com.zhangziwa.practisesvr.service;

import com.zhangziwa.practisesvr.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    Student loginIn(String name, String password);

    List<Student> listStudents(Integer pageNum, Integer PageSize);
    List<Student> listStudents2(Integer pageNum, Integer PageSize);
    List<Student> listStudents3(Integer pageNum, Integer PageSize);
}
