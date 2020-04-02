package com.example.springboot02config.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService
{
    public void sayHello(){
        System.out.println("hello");
    }
}
