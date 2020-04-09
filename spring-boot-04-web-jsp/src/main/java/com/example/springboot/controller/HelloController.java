package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController
{
    @GetMapping("/abc")
    public String sayHello(Model model){
        model.addAttribute("msg","message");
        return "success";
    }
}
