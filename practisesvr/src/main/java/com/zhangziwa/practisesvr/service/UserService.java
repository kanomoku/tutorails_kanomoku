package com.zhangziwa.practisesvr.service;

import com.zhangziwa.practisesvr.model.Student;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Student loginIn(String name, String password);
}
