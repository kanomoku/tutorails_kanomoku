package com.zhangziwa.practisesvr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhangziwa.practisesvr")
public class PractisesvrApplication {

    public static void main(String[] args) {
        SpringApplication.run(PractisesvrApplication.class, args);
    }

}
