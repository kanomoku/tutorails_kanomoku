package com.zhangziwa.practisesvr.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangziwa.practisesvr.mapper.UserMapper;
import com.zhangziwa.practisesvr.model.Student;
import com.zhangziwa.practisesvr.service.UserService;
import com.zhangziwa.practisesvr.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Student> listStudents(Integer pageNum, Integer PageSize) {
        PageHelper.startPage(PageUtils.getPageNum(pageNum), PageUtils.getPageSize(PageSize), PageUtils.isQueryTotalCount());
        PageHelper.orderBy("age asc");
        List<Student> students = userMapper.listStudents();
        PageInfo<Student> studentPageInfo = PageInfo.of(students);
        return students;
    }
}
