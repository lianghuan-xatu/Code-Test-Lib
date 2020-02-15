package itcast.web.登陆案例;

import itcast.web.登陆案例.Utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
    @Test
    public User login(User loginUser) throws ClassNotFoundException {
        /*User loginUser=new User();
        loginUser.setUsername("lianghuan");
        loginUser.setPassword("12345678");*/

        //编写sql
        User user;
       Class.forName("org.springframework.jdbc.core.RowMapper");
        try{
            String sql="select * from user where username = ? and password = ?";
            //掉用query
          user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());

        }catch (Exception e){
            e.printStackTrace();
            user=null;
        }
        System.out.println(user);
        return user;
    }

}
