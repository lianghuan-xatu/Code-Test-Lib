package com.itcast.dao;

import com.itcast.domain.QueryVo;
import com.itcast.domain.User;

import java.util.List;

public interface IUserDao
{
    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer userId);

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
     * 查询总用户数
     *
     */
    int findTotal();


    /**
     * 根据queryVo的条件查询用户
     */
    List<User> findUserByVo(QueryVo vo);



}
