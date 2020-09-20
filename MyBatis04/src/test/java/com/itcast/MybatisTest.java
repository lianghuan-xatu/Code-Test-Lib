package com.itcast;

import com.itcast.dao.IUserDao;

import com.itcast.domain.QueryVo;
import com.itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MybatisTest
{
    private InputStream in ;
    private SqlSession sqlSession;
    private IUserDao dao;
    @Before//用于在测试方法执行之前
    public void init()throws IOException{
        //读取配置文件，生成字节输入流
         in=Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(in);
        //使用工厂对象，创建dao对象
        dao=sqlSessionFactory.openSession().getMapper(IUserDao.class);
    }

   /* @After//用于在测试方法之后
    public void destory() throws IOException {
        //释放资源
        sqlSession.commit();
        sqlSession.close();
        in.close();

    }*/

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
    public void findByIdTest(){


        System.out.println(dao.findById(50));

    }


    /**
     * 根据姓名模糊查询查询一个方法
     *
     */
    @Test
    public void findByNameTest(){

        String username="王";
        List<User> users = dao.findByName("%" + username + "%");
        for(User user:users){
            System.out.println(user);
        }

    }



    /**
     * 根据条件查询查询一个方法
     *
     */
    @Test
    public void findByConditionTest(){
        User u=new User();
        u.setUsername("老王");

        List<User> users = dao.findUserByCondition(u);
        for(User user:users){
            System.out.println(user);
        }

    }

    /**
     *测试foreach标签的使用
     *
     */
    @Test
    public void TestFindInIds(){

        QueryVo vo=new QueryVo();
        List<Integer> list=new ArrayList<>();
        list.add(42);
        list.add(42);
        list.add(46);
        vo.setIds(list);
        User u=new User();
        u.setUsername("老王");

        List<User> users = dao.findUserInIds(vo);
        for(User user:users){
            System.out.println(user);
        }

    }




}






