package Service.impl;

import Dao.ProvinceDao;
import Dao.impl.ProvinceDaoImp;
import Service.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Province;
import jedis.Util.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImp implements ProvinceService
{
    ProvinceDao provinceDao=new ProvinceDaoImp();
    @Override
    public List<Province> findAll() {


        return provinceDao.findAll();
    }

    @Override
    public String findAllJson() {
        //先从redis中查询数据
        //获取redis客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");
        //判断  province_json数据是否为null
        if(province_json==null||province_json.length()==0){
            //redis中没有数据
            System.out.println("redis中没有数据，查询数据库...");
            //从数据库中查询
            List<Province> all = provinceDao.findAll();
            //将all序列化为json
            ObjectMapper mapper=new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(all);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //将json存入redis
            jedis.set("province",province_json);
            //归还连接
            jedis.close();
     }
        return province_json;
    }
}
