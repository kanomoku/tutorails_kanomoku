package com.zhangziwa.practisesvr.controller.specialprac;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 第一个请求 意义非凡
@Controller
public class HelloController {
    @RequestMapping("/map1")
    public String index() {
        return "redirect:index.html";
    }

    @RequestMapping("/map2")
    public String map2() {
        return "redirect:index2.html";
    }
}