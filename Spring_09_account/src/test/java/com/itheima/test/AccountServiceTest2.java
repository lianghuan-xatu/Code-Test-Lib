package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用junit进行单元测试
 */
public class AccountServiceTest2
{

    @Test
    public void testFindAll(){

      /*  假设当我们进行转账操作时由于在查询和更新时我们使用QueryRunner在持久层获取了两个或多个不同的Connection对象
                因此无法进行事务控制，所以只能在业务层创建线程管理，限制获取Connection对象为同一个Connection
                而且在业务层直接实现对持久层的事务控制*/

        //获取容器
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //得到业务层对象
         IAccountService as = ac.getBean("accountService",IAccountService.class);
        List<Account> accounts = as.findAllAccount();

        for(Account account:accounts){
            System.out.println(account);
        }

    }

}
