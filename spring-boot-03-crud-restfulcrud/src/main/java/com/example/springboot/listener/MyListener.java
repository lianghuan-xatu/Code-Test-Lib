package com.example.springboot.listener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener
{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized.........");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed...........");
    }
}
