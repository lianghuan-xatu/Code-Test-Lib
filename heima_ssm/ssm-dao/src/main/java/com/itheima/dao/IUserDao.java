package com.itheima.dao;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.List;

@Repository
public interface IUserDao
{

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many=@Many(select = "com.itheima.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username);

    @Select("select * from users")
    public List<UserInfo> findAll();



    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);



    @Select("select * from users where id = #{userId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many=@Many(select = "com.itheima.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(String userId);



    @Select("select * from role where id not in (select roleId from users_role where userId = #{id}) ")
    List<Role> findUserByIdAndAllRole(String id);


    /**
     * 添加用户的角色
     * @param userId
     * @param roleId
     */
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId,@Param("roleId") String roleId);
}
