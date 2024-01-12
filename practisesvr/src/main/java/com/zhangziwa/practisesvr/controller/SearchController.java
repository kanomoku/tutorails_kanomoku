package com.zhangziwa.practisesvr.controller;

import com.zhangziwa.practisesvr.model.Student;
import com.zhangziwa.practisesvr.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class SearchController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        List<Student> students = userService.listStudents(1, 10);
        students.forEach(System.out::println);
        return students;
    }

    @RequestMapping(value = "/getAllStudents2", method = RequestMethod.GET)
    public List<Student> getAllStudents2() {
        List<Student> students = userService.listStudents2(1, 10);
        students.forEach(System.out::println);
        return students;
    }
}
