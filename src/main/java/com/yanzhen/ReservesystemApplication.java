package com.yanzhen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yanzhen.dao")
public class ReservesystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservesystemApplication.class, args);
    }

}
