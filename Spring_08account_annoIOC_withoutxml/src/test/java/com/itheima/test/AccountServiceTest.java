package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.annotation.Retention;
import java.util.List;

/**
 * 使用junit进行单元测试：测试我们的配置
 * Spring整合Junit的配置
 *          1、导入Spring整合junit的jar（坐标）
 *          2、使用Junit提供的一个注解把原有的main方法替代了，换成spring提供的
 *                  @Runwith
 *         3、告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *                  @ContextConfiguration
 *                      location：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *                      classes:指定注解所在位置
 *       当我们使用Spring5.x版本时要求junit的jar版本必须在4.1.2以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest
{
    @Autowired
    private IAccountService as;

    @Test
    public void testFindAll(){
      /*  //获取容器
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);*/
        //得到业务层对象
      /*   IAccountService as = ac.getBean("accountService",IAccountService.class);*/
        List<Account> accounts = as.findAllAccount();

        for(Account account:accounts){
            System.out.println(account);
        }

    }

    @Test
    public void testFindOne(){
        //获取容器
     /*   ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);*/
        Account a = as.findAccountById(1);
        System.out.println(a);
    }

    @Test
    public void testSave(){
        Account account=new Account();
        account.setId(2);
        account.setName("傻逼");
        account.setMoney((float) 10000);
        //获取容器
     /*   ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);*/
        as.saveAccount(account);
    }

    @Test
    public void testUpdate(){

    }

    @Test
    public void testDelete(){

    }
}
