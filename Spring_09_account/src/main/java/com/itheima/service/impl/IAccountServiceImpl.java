package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户业务层实现类
 */
@Service("accountService")
public class IAccountServiceImpl implements IAccountService
{

    @Autowired
    private IAccountDao accountDao;
    @Autowired
    private TransactionManager txManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.txManager = transactionManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        try{
            //开启事务
            txManager.beginTransaction();
            //执行操作
            List<Account> allAccount = accountDao.findAllAccount();
            //提交事务
            txManager.commit();
            //返回结果
            return allAccount;
        }catch (Exception e){
            //回滚操作
                txManager.rollback();
                throw new RuntimeException(e);
        }finally {
           // 释放连接
                txManager.release();
        }

    }
    @Override
    public void transfer(String sourceName, String targetName, Float money) {

        try{
            //开启事务
            txManager.beginTransaction();
            //执行操作
            //根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //转出账户减钱
        source.setMoney(source.getMoney()-money);
        //转入账户加钱
        target.setMoney(target.getMoney()+money);
        //更新转出账户
        accountDao.updateAccount(source);
        //更新转入账户
        accountDao.updateAccount(target);
            //提交事务
            txManager.commit();
            //返回结果

        }catch (Exception e){
            //回滚操作
                txManager.rollback();

        }finally {
            // 释放连接
                txManager.release();
        }

    }
}
