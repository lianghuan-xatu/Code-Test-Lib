package com.itcast.dao;

import com.itcast.domain.Account;
import com.itcast.domain.AccountUser;

import java.util.List;

public interface IAccountDao {


    /**
     * 查询所有账户，同时还要获取当前账户的所属用户信息
     *
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户，并带有用户名称和地址信息
     * @return
     */
    List<Account> findAllAccount();
}
