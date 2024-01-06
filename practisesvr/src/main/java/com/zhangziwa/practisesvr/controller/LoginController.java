package com.zhangziwa.practisesvr.controller;

import com.zhangziwa.practisesvr.model.Student;
import com.zhangziwa.practisesvr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(String name, String password) {
        System.out.println("name " + name + " password " + password);
        Student student = null;
        try {
            student = userService.loginIn(name, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(student);
        if (student != null) {
            return "success";
        } else {
            return "error";
        }
    }
}