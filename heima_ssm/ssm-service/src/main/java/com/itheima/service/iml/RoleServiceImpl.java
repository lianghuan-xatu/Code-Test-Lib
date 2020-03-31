package com.itheima.service.iml;

import com.itheima.dao.IRoleDao;
import com.itheima.domain.Role;
import com.itheima.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService
{
    @Autowired
    private IRoleDao roleDao;
    @Override
    public List<Role> findAll() {
        List<Role> roles=null;
        try{
           roles=roleDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return roles;
    }

    /**
     * 添加角色信息
     * @param role
     */
    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
