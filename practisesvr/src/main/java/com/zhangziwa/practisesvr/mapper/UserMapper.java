package com.zhangziwa.practisesvr.mapper;

import com.zhangziwa.practisesvr.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    Student getInfo(@Param("name") String name, @Param("password") String password);

    List<Student> listStudents();
}
