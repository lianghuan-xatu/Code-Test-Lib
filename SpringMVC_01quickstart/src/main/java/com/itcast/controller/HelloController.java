package com.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//控制器
@Controller
@RequestMapping("/user")
public class HelloController
{
    @RequestMapping(path = "/hello",params = {"username=heihei"},headers = {"Accept"},method = {RequestMethod.POST})
    public String sayHello(){
        System.out.println("Hello SpringMVC");
        return "success";
    }
}
