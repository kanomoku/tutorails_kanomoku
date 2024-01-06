package com.zhangziwa.practisesvr.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/map1")
    public String index() {
        return "index.html";
    }

    @RequestMapping("/map2")
    public String map2() {
        return "index2.html";
    }
}