package com.zhangziwa.practisesvr.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangziwa.practisesvr.mapper.UserMapper;
import com.zhangziwa.practisesvr.model.Student;
import com.zhangziwa.practisesvr.service.UserService;
import com.zhangziwa.practisesvr.utils.pagehelper.PageHeaderUtils;
import com.zhangziwa.practisesvr.utils.pagehelper.PageUtils;
import com.zhangziwa.practisesvr.utils.response.ResponseContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        // 收集分页信息到 ThreadLocal
        PageHeaderUtils.setPageHeader(studentPageInfo);

        // 收集HttpStatus到 ThreadLocal
        // ResponseContext.setResponseCode(num2HttpStatus("200")); // 为了使用一下num2HttpStatus方法
        ResponseContext.setResponseCode(HttpStatus.OK);
        return students;
    }

    @Override
    public List<Student> listStudents2(Integer pageNum, Integer PageSize) {
        PageHelper.startPage(PageUtils.getPageNum(pageNum), PageUtils.getPageSize(PageSize), PageUtils.isQueryTotalCount());
        PageHelper.orderBy("age asc");

        Page<Student> students = (Page<Student>) userMapper.listStudents();
        PageHeaderUtils.setPageHeader(students);
        ResponseContext.setResponseCode(HttpStatus.OK);
        return students;
    }
}
