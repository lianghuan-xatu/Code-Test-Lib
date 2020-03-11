package com.itcast.mybatis.utils;

import com.itcast.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 创建数据源的工具类
 */
public class DataSourceUtil {
    public static Connection getConnection(Configuration cfg){
        Connection connection=null;
        try{
            Class.forName(cfg.getDriver());
           connection=DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(),cfg.getPassword());

        }catch (Exception e){
            System.out.println("jdbc连接失败");
        }
        return connection;
    }

}
