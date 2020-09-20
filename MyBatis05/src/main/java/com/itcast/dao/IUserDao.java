package com.itcast.dao;

import com.itcast.domain.User;

import java.util.List;

public interface IUserDao
{


    /**
     * 查询所有用户，同时获取用户下所有账户信息
     * @return
     */
    List<User> findAll();


    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findById(Integer id);




}
