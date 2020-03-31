package com.itheima.dao;


import com.itheima.domain.Permission;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface IPermissionDao {

    @Select("select * from permission where id in(select permissionId from role_permission where roleId = #{id})")
    public List<Permission> findByRoleId();

    @Select("select * from permission")
    List<Permission> findAll();
}
