package com.zhangziwa.practisesvr.service;

import com.zhangziwa.practisesvr.model.Student;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

    Student loginIn(String name, String password);

}
