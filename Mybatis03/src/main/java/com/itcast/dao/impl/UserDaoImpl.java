package com.itcast.dao.impl;

import com.itcast.dao.IUserDao;
import com.itcast.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao
{
    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;
    }

    @Override
    public List<User> findAll() {
        //根据factory获取SqlSession对象
        SqlSession session=factory.openSession();
        //调用SqlSession中的方法，实现查询列表
        List<User> users = session.selectList("com.itcast.dao.IUserDao.findAll");//参数就是能获取配置信息的key
        //释放资源
        session.close();
        return users;
    }

    @Override
    public void saveUser(User user) {
        //根据factory获取SqlSession对象
        SqlSession session=factory.openSession();
        //调用SqlSession中的方法，实现保存
        session.insert("com.itcast.dao.IUserDao.saveUser",user);//参数就是能获取配置信息的key
        //提交事务
        session.commit();
        //释放资源
        session.close();

    }

    @Override
    public void updateUser(User user) {
        //根据factory获取SqlSession对象
        SqlSession session=factory.openSession();
        //调用SqlSession中的方法，实现保存
        session.update("com.itcast.dao.IUserDao.updateUser",user);//参数就是能获取配置信息的key
        //提交事务
        session.commit();
        //释放资源
        session.close();
    }

    @Override
    public void deleteUser(Integer userId) {
        //根据factory获取SqlSession对象
        SqlSession session=factory.openSession();
        //调用SqlSession中的方法，实现保存
        session.update("com.itcast.dao.IUserDao.deleteUser",userId);//参数就是能获取配置信息的key
        //提交事务
        session.commit();
        //释放资源
        session.close();
    }

    @Override
    public User findById(Integer id) {
    //根据factory获取SqlSession对象
    SqlSession session=factory.openSession();
    //调用SqlSession中的方法，实现查询一个
    User user = session.selectOne("com.itcast.dao.IUserDao.findById",id);//参数就是能获取配置信息的key
    //释放资源
        session.close();
        return user;
    }


    @Override
    public List<User> findByName(String name) {
        //根据factory获取SqlSession对象
        SqlSession session=factory.openSession();
        //调用SqlSession中的方法，实现查询
        List<User> users = session.selectList("com.itcast.dao.IUserDao.findByName",name);//参数就是能获取配置信息的key
        //释放资源
        session.close();
        return users;
    }

    @Override
    public int findTotal() {
        //根据factory获取SqlSession对象
        SqlSession session=factory.openSession();
        //调用SqlSession中的方法，实现查询一个
        Integer count= session.selectOne("com.itcast.dao.IUserDao.findByTotal");//参数就是能获取配置信息的key
        //释放资源
        session.close();
        return count;
    }
}
