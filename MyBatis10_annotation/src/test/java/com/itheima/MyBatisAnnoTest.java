package com.itheima;


import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class MyBatisAnnoTest {
    private InputStream in ;
    private SqlSession sqlSession;
    private IUserDao dao;
    @Before//用于在测试方法执行之前
    public void init()throws IOException {
        //读取配置文件，生成字节输入流
        in=Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(in);
        //使用工厂对象，创建dao对象
        sqlSession=sqlSessionFactory.openSession();
         dao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于在测试方法之后
    public void destory() throws IOException {
        //释放资源
        sqlSession.commit();
        sqlSession.close();
        in.close();

    }

    /**
     * 查询方法
     */
    @Test
    public void testFindAll()  {

        //执行方法
        List<User> users=dao.findAll();
        for(User user:users){
            System.out.println(user);
        }

    }

    @Test
    public void testSaveUser(){
        User user=new User();
        user.setUsername("张三");
        user.setSex("男");
        user.setAddress("陕西宝鸡");
        user.setBirthday(new Date());
        dao.saveUser(user);
    }

    @Test
    public void testUpdateUser(){
        User user=new User();
        user.setId(51);
        user.setUsername("张三");
        user.setSex("男");
        user.setAddress("日本东京");
        user.setBirthday(new Date());
        dao.updateUser(user);
    }


    @Test
    public void testDeleteUser(){
        dao.deleteUser(51);
    }

    @Test
    public void testfindUserById(){
       System.out.println(dao.findById(52));
    }

    @Test
    public void testfindUserByName(){
        List<User> users = dao.findUserByUserName("%" + "王" + "%");
        for(User user:users){
            System.out.println(user);
        }
    }


    @Test
    public void testfindTotal(){
        System.out.println(dao.findTotalUser());
    }

}
