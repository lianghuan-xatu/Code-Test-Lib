package com.example.springboot02config.config;

import com.example.springboot02config.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 指明当前类是一个配置类    使用配置类添加组件
 */
@Configuration
public class MyAppConfig
{
    /**
     * 将方法的返回值添加到容器中；容器中这个组件哦人的id就是方法名
     * @return
     */
    @Bean
    public HelloService createService(){
            System.out.println("通过配置类添加组件");
            return new HelloService();
    }
}
