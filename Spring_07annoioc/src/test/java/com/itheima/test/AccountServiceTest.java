package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用junit进行单元测试
 */
public class AccountServiceTest
{

    @Test
    public void testFindAll(){
        //获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象
         IAccountService as = ac.getBean("accountService",IAccountService.class);
        List<Account> accounts = as.findAllAccount();

        for(Account account:accounts){
            System.out.println(account);
        }

    }

    @Test
    public void testFindOne(){
        //获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
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
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        as.saveAccount(account);
    }

    @Test
    public void testUpdate(){

    }

    @Test
    public void testDelete(){

    }
}
