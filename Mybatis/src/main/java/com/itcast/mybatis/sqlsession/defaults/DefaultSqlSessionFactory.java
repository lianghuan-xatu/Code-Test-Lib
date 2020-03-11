package com.itcast.mybatis.sqlsession.defaults;

import com.itcast.mybatis.cfg.Configuration;
import com.itcast.mybatis.sqlsession.SqlSession;
import com.itcast.mybatis.sqlsession.SqlSessionFactory;

import java.util.zip.DataFormatException;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg=cfg;
    }
    //用于创建一个新的
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
