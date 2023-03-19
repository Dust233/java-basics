package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author LiJingZhi
 * @since 2023-02-25 21:22
 */
@SpringBootApplication
@MapperScan("com.example.mybatis.mapper")
public class JavaBasicsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaBasicsApplication.class, args);
    }

}
