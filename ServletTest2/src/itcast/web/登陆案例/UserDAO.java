package itcast.web.登陆案例;

import itcast.web.登陆案例.Utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/*
操作数据库中Users表的类*/
public class UserDAO
{

    /*声明JDBCTemplate对象公用*/
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * 登陆方法
     * @param loginUser   只有用户名和密码
     * @return   用户的所有信息  没有查询到返回null
     */
    public User login(User loginUser){
        //编写sql
        try{
        String sql="select * from user where username = ? and password = ?";
        //掉用query
        User user = template.queryForObject(sql,
                new BeanPropertyRowMapper<User>(User.class),
                loginUser.getUsername(), loginUser.getPassword());


        return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
