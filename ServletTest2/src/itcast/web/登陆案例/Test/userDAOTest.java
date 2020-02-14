package itcast.web.登陆案例.Test;

import itcast.web.登陆案例.User;
import itcast.web.登陆案例.Utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class userDAOTest
{

    /*声明JDBCTemplate对象公用*/
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * 登陆方法
     * @param loginUser   只有用户名和密码
     * @return   用户的所有信息  没有查询到返回null
     */
    @Test
    public void login(){
        User loginUser=new User();
        loginUser.setUsername("lianghuan");
        loginUser.setPassword("12345678");

        //编写sql
        User user;
        try{
            String sql="select * from user where username = ? and password = ?";
            //掉用query
            user= template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());

        }catch (Exception e){
            e.printStackTrace();
            user=null;
        }
        System.out.println(user);
    }
}
