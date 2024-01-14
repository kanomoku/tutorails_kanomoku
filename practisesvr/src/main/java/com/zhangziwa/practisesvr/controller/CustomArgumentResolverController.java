package com.zhangziwa.practisesvr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class CustomArgumentResolverController {

    @GetMapping("/customDateArgumentResolver")
    public String customDateArgumentResolver(Date date) {
        // 此处的date参数会由CustomDateArgumentResolver解析注入
        System.out.println(date);
        return "success";
    }
}