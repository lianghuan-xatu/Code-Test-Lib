package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

public class FavoriteDaoImpl implements FavoriteDao
{
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Favorite findByRidAndUid(int rid, int uid) {
        Favorite favorite=null;
        String sql="select * from tab_favorite where rid = ? and uid = ?";
        try{
            favorite = template.queryForObject(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class), rid, uid);

        }catch (Exception e){

        }

        return favorite;
    }

    /**
     * 查找被收藏次数
     * @param rid
     * @return
     */
    @Override
    public int findCountByRid(int rid) {
        String sql="select count(*) from tab_favorite where rid = ?";
        return template.queryForObject(sql,Integer.class,rid);
    }

    /**
     * 为线路添加收藏
     * @param rid
     * @param uid
     */
    @Override
    public void add(int rid, int uid) {
        String sql="insert into tab_favorite values(?,?,?)";
        template.update(sql,rid,new Date(),uid);


    }
}
