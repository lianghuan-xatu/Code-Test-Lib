package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;

import com.itheima.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

//    private int i = 1;

    public void  saveAccount(){
     System.out.println("Service中的saveAccount方法");
    }
    public void init(){
        System.out.println("对象被创建了");
    }
    public void destory(){
        System.out.println("对象被销毁了");
    }
}
