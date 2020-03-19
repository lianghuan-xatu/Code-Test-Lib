package com.itheima.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 和事务管理相关的工具类，包含了，开启事务，提交事务，回滚事务和释放连接
 */
@Component
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransaction() throws SQLException {

        try{
          connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            throw new RuntimeException(e);
        }


    }

    /**
     * 提交事务
     */
    public void commit() {
        try{
            connectionUtils.getThreadConnection().commit();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }


    /**
     *  回滚事务
     */
    public void rollback() {
        try{
            connectionUtils.getThreadConnection().rollback();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    /**
     * 释放连接
     */
    public void release(){

        try{
            connectionUtils.getThreadConnection().close();  //还回连接池中
            connectionUtils.removeConnection();
        }catch (Exception e){
            throw new RuntimeException(e);
        }


    }




}
