package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JDBCUtils;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService
{
    CategoryDao dao=new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        //从redis中查询
        Jedis jedis= JedisUtil.getJedis();
        //使用sortedset排序查询
        Set<Tuple> categorys = jedis.zrangeWithScores("category", 0, -1);
        List<Category> cs=null;
        //判断是否为空
        if(categorys==null||categorys.size()==0){
            //如果为空，需要从数据库中查询数据再保存数据到redis
            cs=dao.findAll();
            //将集合数据存储到redis中的category的key
            for(int i=0;i<cs.size();i++){
                jedis.zadd("category",cs.get(i).getCid(),cs.get(i).getCname());
            }
        }else{
            //如果不为空，将set数据存入list  返回list
            cs=new ArrayList<Category>();
            for( Tuple tuple : categorys){
                Category category=new Category();
                category.setCname(tuple.getElement());
                category.setCid((int) tuple.getScore());
                cs.add(category);
            }
        }
        return cs;
    }
}
