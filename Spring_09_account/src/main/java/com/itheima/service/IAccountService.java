package com.itheima.service;


import com.itheima.domain.Account;

import java.util.List;

/**
 * 业务层接口
 */
public interface IAccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();


    void transfer(String sourceName,String targetName,Float money);
}
