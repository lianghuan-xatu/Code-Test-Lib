package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao
{
     JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public void save(User user) {
        //定义sql
        String sql="insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code) values(?,?,?,?,?,?,?,?,?)";
        //执行sql
        template.update(sql,user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode());

    }


    @Override
    public User findByUsername(String username) {
        //定义sql
        String sql="select * from tab_user where username = ?";
        //执行sql
        User user = null;
        try{
            user=template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        }catch (Exception e){

        }

        return user;
    }

    /**
     * 根据激活码查询用户对象
     * @param code
     * @return
     */
    @Override
    public User findByCode(String code) {
        String sql="select * from tab_user where code = ?";
        User user=null;
        try{
            user= template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
        }catch (Exception e){

        }
        return user;
    }

    /**
     * 修改用户状态
     * @param user
     */
    @Override
    public void updateStatus(User user) {
        String sql="update tab_user set status = 'Y' where uid = ? ";
        template.update(sql,user.getUid());
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user=null;
        try{
            //定义sql
            String sql="select * from tab_user where username= ? and password = ?";
            //执行sql
            user= template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);

        }catch (Exception e){

        }
        return user;
    }
}
