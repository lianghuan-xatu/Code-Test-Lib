package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 在MyBatis中注解，CRUD一共四个注解
 *
 * @SELECT @INSERT   @UPDATE    @DELETE
 */
@CacheNamespace(blocking = true)
public interface IUserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(id = true, property = "userId", column = "id"),
            @Result(property = "userName", column = "username"),
            @Result(property = "userAddress", column = "address"),
            @Result(property = "userSex", column = "sex"),
            @Result(property = "userBirthday", column = "birthday"),
            @Result(property = "accounts", column = "id", many = @Many(select = "com.itheima.dao.IAccountDao.findAccountByUid", fetchType = FetchType.LAZY))

    })
    List<User> findAll();


    /**
     * 根据id查询用户
     *
     * @param userId
     * @return
     */
    @Select("select * from user where id=#{userId}")
    User findById(Integer userId);

    /**
     * 根据用户名称模糊查询
     *
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    @ResultMap(value = {"userMap"})
    List<User> findUserByUserName(String username);

}
