package com.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController
{
    @RequestMapping("/testInterceptor")
    public String testIntercepor(){
        System.out.println("testInterceptor...");
        return "success";
    }
}
