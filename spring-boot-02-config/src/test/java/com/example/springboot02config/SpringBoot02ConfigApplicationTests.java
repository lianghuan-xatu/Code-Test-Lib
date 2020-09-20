package com.example.springboot02config;

import com.example.springboot02config.bean.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Spring-Boot单元测试
 * 可以在测试期间很方便的类似编码一样进行自动注入等
 */
@ImportResource(locations = {"classpath:beans.xml"})  //导入Spring配置文件  让其生效
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBoot02ConfigApplicationTests {
   @Autowired
    Person person;
   @Autowired
   ApplicationContext ioc;
    @Test
    void contextLoads() {
        System.out.println(person);
    }


    public void TestHelloServie(){
        boolean flag = ioc.containsBean("helloService");
        System.out.println(flag);

    }

}
