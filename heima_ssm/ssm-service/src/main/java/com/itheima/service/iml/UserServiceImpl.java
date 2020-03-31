package com.itheima.service.iml;

import com.itheima.dao.IUserDao;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo =null;
        try{
            userInfo=userDao.findByUsername(username);
        }catch (Exception e){
            e.printStackTrace();
        }//进行异常处理  如没有查询到用户不会直接抛出异常
        //创建User对象   此对象是spring-security为我们提供的ke封装数据的UserDetails的实现类
     //   User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user=new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true, true,true,true,getAuthority(userInfo.getRoles()));
        //第三个参数authorities中放入List集合，装入的是集合描述
       /* 将数据库中的userInfo对象查询出来之后为什么要封装到UserDetails对象中：
        封装之后spring-security框架会自动为我们实现认证
        如果正确会跳转到相关页面   如果失败同理*/
        return user;
    }

    //返回List集合，装入的是集合描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roleList){
       List<SimpleGrantedAuthority> list=new ArrayList<>();
       for(Role role:roleList){
           list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));//new SimpleGrantedAuthority("ROLE_"+role.getRoleName())
       }
        return list;
    }


    public List<UserInfo> findAll(){
        List<UserInfo> list=null;
        list= userDao.findAll();
        return list;
    }

    @Override
    public void save(UserInfo userInfo) {
        //对密码进行加密处理
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String userId) {
        UserInfo user=null;
        user=userDao.findById(userId);
        return user;
    }

    /**
     * 根据用户id来查出用户还没有添加的角色信息
     * @param id
     * @return
     */
    @Override
    public List<Role> findUserByIdAndAllRole(String id) {
        List<Role> list=null;
        try{
            list=userDao.findUserByIdAndAllRole(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        for(int i=0;i<roleIds.length;i++){
            String roleId=roleIds[i];
            userDao.addRoleToUser(userId,roleId);
        }
    }
}
