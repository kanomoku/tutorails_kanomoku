package com.zhangziwa.practisesvr.serviceImpl;

import com.zhangziwa.practisesvr.mapper.UserMapper;
import com.zhangziwa.practisesvr.model.Student;
import com.zhangziwa.practisesvr.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Student loginIn(String name, String password) {
        log.info("input name {}, password {}", name, password);
        if (ObjectUtils.anyNull(name, password)) {
            log.warn("input name {}, password {}", name, password);
            return null;
        }
        return userMapper.getInfo(name, password);
    }
}
