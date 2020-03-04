package jedis.test;

import jedis.Util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jedis的测试类
 */
public class JedisTest {
    @Test
    public void test1(){
        //1、获取连接
        Jedis jedis=new Jedis("localhost",6379);
        //2、操作
        jedis.set("username","zhangsan");
        //3、关闭连接
        jedis.close();

    }

    /**
     * String 数据结构的操作
     */
    @Test
    public void test2(){
        //1、获取连接
        Jedis jedis=new Jedis();//如果使用空参构造，默认值"localhost",6379
        //2、操作
        jedis.set("username","zhangsan");
        //获取
        String username = jedis.get("username");
        System.out.println(username);
        //可以使用setex()方法存储可以指定过期时间的key value
        jedis.setex("activecode",20,"hehe");//将activecode:hehe键值对存入redis，并且20秒之后自动删除键值对
        //3、关闭连接
        jedis.close();

    }
    /**
     * Hash 数据结构的操作
     */
    @Test
    public void test3(){
        //1、获取连接
        Jedis jedis=new Jedis();//如果使用空参构造，默认值"localhost",6379
        //2、操作
        jedis.hset("user","name","lisi");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","male");
        //获取
        String name = jedis.hget("user", "name");
        System.out.println(name);

        //获取hash中的所有map中的数据
        Map<String, String> user = jedis.hgetAll("user");
        Set<String> keys = user.keySet();
        for(String key :keys){
            String value = user.get(key);
            System.out.println(value);
        }

        //3、关闭连接
        jedis.close();

    }
    /**
     * List 数据结构的操作
     */
    @Test
    public void test4(){
        //1、获取连接
        Jedis jedis=new Jedis();//如果使用空参构造，默认值"localhost",6379
        //2、操作
        jedis.lpush("mylist","a","b","c");//从左边存
        jedis.rpush("mylist","a","b","c");//从右边存
        //list范围获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);
        //list弹出
        String element1 = jedis.lpop("mylist");
        String element2 = jedis.rpop("mylist");
        System.out.println(element1);
        System.out.println(element2);

        //3、关闭连接
        jedis.close();

    }
    /**
     * Set 数据结构的操作
     */
    @Test
    public void test5(){
        //1、获取连接
        Jedis jedis=new Jedis();//如果使用空参构造，默认值"localhost",6379
        //2、操作
        //set存储
        jedis.sadd("myset","java","php","c++");
        //set获取
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);

        //3、关闭连接
        jedis.close();

    }
    /**
     * SortedSet 数据结构的操作
     */
    @Test
    public void test6(){
        //1、获取连接
        Jedis jedis=new Jedis();//如果使用空参构造，默认值"localhost",6379
        //2、操作
        //sortedset存储
        jedis.zadd("mysortedset",3,"亚瑟");
        jedis.zadd("mysortedset",30,"孙悟空");
        jedis.zadd("mysortedset",25,"后裔");
        //sortedset获取
        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
        System.out.println(mysortedset);

        //3、关闭连接
        jedis.close();

    }
    @Test
    public void test7(){
        //创建配置对象
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        //创建Jedis连接池对象
        JedisPool jedisPool=new JedisPool();
        //获取连接
        Jedis jedis=jedisPool.getResource();
        //使用
        jedis.set("hehe","haha");
        //关闭  归还到连接池中
        jedis.close();
    }

    /**
     * Jedis连接池工具类的使用
     */
    @Test
    public void test8(){
        //创建配置对象
        //通过连接池工具类来获取
        Jedis jedis = JedisPoolUtils.getJedis();
        //使用
        jedis.set("hehe","haha");
        //关闭  归还到连接池中
        jedis.close();
    }
}
