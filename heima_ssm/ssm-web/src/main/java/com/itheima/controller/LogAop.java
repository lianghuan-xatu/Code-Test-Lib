package com.itheima.controller;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    private Date visitTime;//开始时间
    private Class clazz; //访问的类
    private Method method; //访问的方法
    /**
     * 前置通知 主要获取开始时间，执行的是哪个类，执行的是哪一个方法
     * @param jp
     */
    @Before("execution(* com.itheima.controller.*.*(..))")
    public void doBefore(JoinPoint jp){
        visitTime=new Date();   //当前时间就是
    }


    /**
     * 后置通知
     * @param jp
     */
    @After("execution(* com.itheima.controller.*.*(..))")
    public void doAfter(JoinPoint jp){


    }
}
