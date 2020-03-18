package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接的工具类，它用于从数据源中获取一个连接，并且实现和线程的绑定
 */
@Component
public class ConnectionUtils {
    private ThreadLocal<Connection> tl=new ThreadLocal<>();
    @Autowired
    @Qualifier("dataSource1")
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     */
    public Connection getThreadConnection() throws SQLException {
        //先从ThreadLocal上获取
        Connection conn=tl.get();
        //判断当前线程上是否有连接
        if(conn==null){
            //从数据源中获取一个连接，并且存入ThreadLocal中
            conn = dataSource.getConnection();
            tl.set(conn);
        }
        return conn;
    }

    /**
     * 将连接和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }


}
