package com.zhangziwa.practisesvr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.zhangziwa.practisesvr.mapper")
@EnableScheduling
public class PractisesvrApplication {

    public static void main(String[] args) {
        SpringApplication.run(PractisesvrApplication.class, args);
    }

}
