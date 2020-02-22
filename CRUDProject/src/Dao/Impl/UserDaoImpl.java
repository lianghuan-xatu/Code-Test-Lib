package Dao.Impl;

import Dao.UserDao;
import Domain.User;
import Util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
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

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try{
        DataSource dataSource = JDBCUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //定义sql
        String sql="select * from student where username = ? and password = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        DataSource dataSource = JDBCUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //定义sql
        String sql="insert into student values(null,?,?,?,?,?,?,null,null)";
        String name = user.getName();

        jdbcTemplate.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());

    }

    @Override
    public void deleteUser(int id) {
        DataSource dataSource = JDBCUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //定义sql
        String sql="delete from student where id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public User findUserById(int id) {
        DataSource dataSource = JDBCUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //定义sql
        String sql="select * from student where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        DataSource dataSource = JDBCUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //定义sql
        String sql="update student set name = ? ,gender = ?,age = ?,address = ?,qq = ?,email = ? where id =?";
        jdbcTemplate.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());


    }

    @Override
    public int findTotalCount(int currentPage, int rows, Map<String, String[]> parameterMap) {
        DataSource dataSource = JDBCUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //定义sql
        String sql="select count(*) from student where 1 = 1";
        StringBuilder sb=new StringBuilder(sql);
        List<String> valueList=new ArrayList<>();
        for(String key:parameterMap.keySet()){
            if(key.equals("currentPage")||key.equals("rows"))
                continue;//  排除分页参数
            String value = parameterMap.get(key)[0];
            if((value!=null)&&(!value.equals(""))){
                //有值
                sb.append(" and "+key+" like ? ");
                valueList.add("%"+value+"%");
            }
        }
        int count = jdbcTemplate.queryForObject(sb.toString(), Integer.class,valueList.toArray());
        System.out.println(count);
        System.out.println(valueList);
        return count;
    }

    @Override
    public List<User> findPageList(int start, int rows, Map<String, String[]> parameterMap) {
        DataSource dataSource = JDBCUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //定义sql
        String sql="select * from student where 1 = 1";
        StringBuilder sb=new StringBuilder(sql);
        List<Object> valueList=new ArrayList<>();
        for(String key:parameterMap.keySet()){
            if(key.equals("currentPage")||key.equals("rows"))
                continue;//  排除分页参数
            String value = parameterMap.get(key)[0];
            if((value!=null)&&(!value.equals(""))){
                //有值
                sb.append(" and "+key+" like ? ");
                valueList.add("%"+value+"%");
            }
        }
        sb.append(" limit ?,?");
        valueList.add(start);
        valueList.add(rows);
        List<User> list = jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class), valueList.toArray());

        return list;
    }
}
