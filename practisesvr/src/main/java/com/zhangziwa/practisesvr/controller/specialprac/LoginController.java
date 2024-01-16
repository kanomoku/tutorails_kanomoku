package com.zhangziwa.practisesvr.controller.specialprac;

import com.zhangziwa.practisesvr.model.Student;
import com.zhangziwa.practisesvr.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class LoginController {

    @Autowired
    UserService userService;

    // 为了返回登录页面
    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(String name, String password) {
        Student student = userService.loginIn(name, password);
        log.info("student {}", student);
        if (student != null) {
            return "success";
        } else {
            return "error";
        }
    }
}
