package com.zhangziwa.practisesvr.mapper;

import com.zhangziwa.practisesvr.model.Student;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    Student getInfo(String name, String password);

}
