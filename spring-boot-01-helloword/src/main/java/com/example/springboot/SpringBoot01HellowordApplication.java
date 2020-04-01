package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 主程序类，入口类
 * @SpringBootApplication来标注一个主程序类，说明这是一个SpringBoot应用
 */
@SpringBootApplication
public class SpringBoot01HellowordApplication {

    public static void main(String[] args) {
        /**
         *   SpringBoot应用运行起来
         */
        SpringApplication.run(SpringBoot01HellowordApplication.class, args);
    }

}
