package com.zhangziwa.practisesvr.serviceImpl;

import com.zhangziwa.practisesvr.mapper.UserMapper;
import com.zhangziwa.practisesvr.model.Student;
import com.zhangziwa.practisesvr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Student loginIn(String name, String password) {
        System.out.println("2name " + name + " 2password " + password);
        return userMapper.getInfo(name, password);
    }
}
