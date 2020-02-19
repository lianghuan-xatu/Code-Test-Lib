package Dao.Impl;

import Dao.UserDao;
import Domain.User;
import Util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        //使用jdbc操作数据库
        DataSource dataSource = JDBCUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //定义sql
        String sql="select * from student";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }
}
