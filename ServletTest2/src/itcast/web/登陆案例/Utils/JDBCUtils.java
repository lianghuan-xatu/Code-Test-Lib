package itcast.web.登陆案例.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/*JDBC工具类，使用Druid连接池*/
public class JDBCUtils {
    private static DataSource ds;
    static {
        Properties pro=new Properties();
        ClassLoader classLoader = JDBCUtils.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("druid.properties");
        try {
            pro.load(resourceAsStream);
            ds= DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static DataSource getDataSource(){
    return ds;
    }
}
