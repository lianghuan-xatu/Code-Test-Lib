package com.itheima;


import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
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


public class SecondLevelCacheTest {
    private InputStream in ;
    private SqlSession sqlSession;
    private SqlSessionFactory sqlSessionFactory;
    private IUserDao dao;
    @Before//用于在测试方法执行之前
    public void init()throws IOException {
        //读取配置文件，生成字节输入流
        in=Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        sqlSessionFactory=sqlSessionFactoryBuilder.build(in);
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
            System.out.println(user.getAccounts());
        }

    }




    @Test
    public void testfindUserById(){
        User user = dao.findById(57);
        System.out.println(user);
        sqlSession.close();//释放一级缓存
        SqlSession session1=sqlSessionFactory.openSession();//再次打开session
        IUserDao userDao1=session1.getMapper(IUserDao.class);
        User user1 = userDao1.findById(57);
        System.out.println(user1);


    }



}
