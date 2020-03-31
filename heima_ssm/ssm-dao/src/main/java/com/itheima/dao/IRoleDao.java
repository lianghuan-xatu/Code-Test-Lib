package com.itheima.dao;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleDao {


    /**
     * 根据用户id查询出所有对应角色
     * @param UserId
     * @return
     */
    @Select("select * from role where id in (select roleId from users_role where userId = #{UserId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.dao.IPermissionDao.findByRoleId"))
    })
    List<Role> findRoleByUserId(String UserId);


    /**
     * 查询出所有角色信息
     * @return
     */
    @Select("select * from role")
    List<Role> findAll();

    @Select("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);
}
