package com.itcast.mybatis.sqlsession.defaults;

import com.itcast.mybatis.cfg.Configuration;
import com.itcast.mybatis.sqlsession.SqlSession;
import com.itcast.mybatis.sqlsession.proxy.MapperProxy;
import com.itcast.mybatis.utils.DataSourceUtil;

import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * SqlSession的实现类
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection connection;


    DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;

    }

    /**
     * 用于创建代理对象
     *
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        connection=DataSourceUtil.getConnection(cfg);
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},
                new MapperProxy(cfg.getMappers(), connection));//增强daoInterfaceClass里面的方法

    }

    /**
     * 用于释放资源
     */
    @Override
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
            }

        }
    }
}