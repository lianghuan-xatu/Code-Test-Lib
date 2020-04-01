package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//这个类的所有方法返回的数据直接写给浏览器（如果是对象转换为json数据）
/*@ResponseBody
@Controller*/
@RestController   //是对前面两个配置的代替
public class HelloController {

    @RequestMapping("/hello")
    public String Hello(){
        return "hello world quick!";
    }


}
