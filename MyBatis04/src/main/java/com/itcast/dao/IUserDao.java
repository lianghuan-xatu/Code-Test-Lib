package com.itcast.dao;

import com.itcast.domain.QueryVo;
import com.itcast.domain.User;

import java.util.List;

public interface IUserDao
{
    List<User> findAll();


    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 根据姓名模糊查询用户
     * @param
     * @return
     */
    List<User> findByName(String name);


    /**
     * 根据传入条件
     * @param user  查询的条件，有可能有用户名，有可能有性别，有可能有地址    还有可能全都有
     * @return
     */
    List<User> findUserByCondition(User user);


    /**
     * 根据queryvo中提供的id集合，查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);








}
