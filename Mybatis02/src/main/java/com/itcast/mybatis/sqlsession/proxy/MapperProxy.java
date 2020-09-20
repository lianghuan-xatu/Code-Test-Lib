package com.itcast.mybatis.sqlsession.proxy;

import com.itcast.mybatis.cfg.Mapper;
import com.itcast.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    //key是全限定类名加方法名
    private Map<String, Mapper> mappers;
    private Connection conn;
    public MapperProxy(Map<String,Mapper> mappers,Connection conn){
        this.mappers=mappers;
        this.conn=conn;
    }
    /**
     * 用于对方法的增强，我们的增强其实就是调用selectList方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取方法名
        String methodName = method.getName();
        //获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        //组合key
        String key=className+"."+methodName;
        //获取mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
        if(mapper==null){
            throw new IllegalArgumentException("传入参数错误");

        }
        //调用工具类查询所有
        return new Executor().selectList(mapper,conn);
    }
}
