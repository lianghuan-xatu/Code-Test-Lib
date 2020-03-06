package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl implements UserService
{
    UserDao dao=new UserDaoImpl();
    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        //根据用户名查询用户对象
        User u = dao.findByUsername(user.getUsername());
        //判断u是否为null
        if(u!=null){
            //用户名存在
            return false;
        }else{
            //保存用户信息
            //设置激活码
            user.setCode(UuidUtil.getUuid());
            //设置激活状态
            user.setStatus("N");
            //保存用户信息
            dao.save(user);
            //激活邮件，发送邮件正文
            String context="<a href='http://localhost/travel/activeUserServlet?code="+user.getCode()+"'>黑马旅游网，请激活";
            MailUtils.sendMail(user.getEmail(),context,"激活邮件");
            return true;
        }

    }

    @Override
    public boolean active(String code) {
        //根据激活码返回用户
        User user=dao.findByCode(code);
        if(user!=null){
            //调用dao的修改激活状态的方法
            dao.updateStatus(user);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public User login(User user) {
        return dao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
