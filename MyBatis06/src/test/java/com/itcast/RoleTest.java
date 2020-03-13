package com.itcast;

import com.itcast.dao.IRoleDao;
import com.itcast.dao.IUserDao;
import com.itcast.domain.Role;
import com.itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.java2d.loops.DrawPolygons;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class RoleTest
{
    private InputStream in ;
    private SqlSession sqlSession;
    private IRoleDao dao;
    @Before//用于在测试方法执行之前
    public void init()throws IOException{
        //读取配置文件，生成字节输入流
         in=Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(in);
        sqlSession=sqlSessionFactory.openSession();
        //使用工厂对象，创建dao对象
        dao=sqlSession.getMapper(IRoleDao.class);
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
        List<Role> roles=dao.findAll();
        for(Role role:roles){
            System.out.println(role);
System.out.println(role.getUsers());

        }

    }





}






