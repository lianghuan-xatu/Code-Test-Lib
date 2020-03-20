package com.itheima.test;


import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 单元测试QueryRunner对象是否单例
 */
public class QueryRunnertest
{
    public static void main(String args[]){
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner runner1=ac.getBean("runner",QueryRunner.class);
        QueryRunner runner2=ac.getBean("runner",QueryRunner.class);


        System.out.println(runner1==runner2);
        }
}


