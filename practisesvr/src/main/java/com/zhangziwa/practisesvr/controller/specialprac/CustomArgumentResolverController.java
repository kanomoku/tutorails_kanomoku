package com.zhangziwa.practisesvr.controller.specialprac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class CustomArgumentResolverController {

    @GetMapping("/customDateArgumentResolver")
    public String customDateArgumentResolver(Date date) {
        // 此处的date参数会由CustomDateArgumentResolver解析注入
        System.out.println(date);
        return "success";
    }

    @GetMapping("/dateAddFormatters")
    public String dateAddFormatters(@RequestParam("startDate") Date date1, @RequestParam(value = "endDate", required = false) Date date2) {
        // addFormatters里配置的处理日期逻辑
        System.out.println(date1);
        System.out.println(date2);
        return "success";
    }
}