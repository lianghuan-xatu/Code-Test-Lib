package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


@Service("accountService")
@Scope("prototype")
public class AccountServiceImpl2 implements IAccountService {

  //  @Autowired
   // @Qualifier("accountDao1")
    @Resource(name = "accoutDao2")
    private IAccountDao accountDao=null ;

    public AccountServiceImpl2(){
        System.out.println("对象创建了");
    }

    public void  saveAccount(){
        accountDao.saveAccount();
    }

    @PostConstruct
    public void init(){
        System.out.println("对象被创建了");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("对象被销毁了");
    }
}
