package com.itcast;

import com.itcast.dao.IAccountDao;
import com.itcast.dao.IUserDao;
import com.itcast.domain.Account;
import com.itcast.domain.AccountUser;
import com.itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class AccountTest
{
    private InputStream in ;
    private SqlSession sqlSession;
    private IAccountDao accountDao;
    @Before//用于在测试方法执行之前
    public void init()throws IOException{
        //读取配置文件，生成字节输入流
         in=Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(in);
        sqlSession=sqlSessionFactory.openSession();
        //使用工厂对象，创建dao对象
        accountDao=sqlSession.getMapper(IAccountDao.class);
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
        List<Account> accounts=accountDao.findAll();
        for(Account account:accounts){
            System.out.println(account);
        }

    }


    /**
     * 查询所有账户同时包含用户信息
     */
    @Test
    public void testFindAccount()  {

        //执行方法
        List<Account> accounts=accountDao.findAllAccount();
        for(Account account:accounts){
            System.out.println("--------------每个account信息-----------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }

    }


}






