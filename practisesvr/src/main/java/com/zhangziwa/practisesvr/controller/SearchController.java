package com.zhangziwa.practisesvr.controller;

import com.zhangziwa.practisesvr.model.Student;
import com.zhangziwa.practisesvr.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/getAllStudents3", method = RequestMethod.GET)
    public List<Student> getAllStudents3() {
        List<Student> students = userService.listStudents3(1, 5);
        students.forEach(System.out::println);
        return students;
    }

    @RequestMapping(value = "/getAllStudents4", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllStudents4() {
        if (true){
            throw new UnsupportedOperationException();
        }

        List<Student> students = userService.listStudents3(1, 5);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("test", "test");
        return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.APPLICATION_JSON).body(students);
    }
}
