package Dao.impl;

import Dao.ProvinceDao;
import Util.JDBCUtils;
import domain.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ProvinceDaoImp implements ProvinceDao
{

    @Override
    public List<Province> findAll() {
        String sql="select * from province";
        DataSource dataSource = JDBCUtils.getDataSource();
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        List<Province> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
