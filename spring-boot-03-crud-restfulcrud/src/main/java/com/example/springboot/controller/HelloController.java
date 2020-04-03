package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController
{

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }


    //查出一下数据在页面展示
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","你好");
        return "success";
    }

    @RequestMapping({"/","/index.html"})
    public String index(){
        return "index";
    }
}
