package com.itheima.service.iml;

import com.itheima.dao.IPermissionDao;
import com.itheima.domain.Permission;
import com.itheima.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService
{
    @Autowired
    IPermissionDao permissionDao;
    @Override
    public List<Permission> findAll() {
        List<Permission> list=null;
        try{
            list=permissionDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
