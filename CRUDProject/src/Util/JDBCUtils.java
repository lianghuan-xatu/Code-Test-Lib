package Util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static Connection connection = null;
    private static DataSource dataSource=null;
    static {
        try {
            //加载配置文件
        Properties pro=new Properties();
        ClassLoader classLoader = JDBCUtils.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("druid.properties");
            pro.load(resourceAsStream);
            //初始化连接池对象
           dataSource= DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){

        try {
            connection = dataSource.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
    //释放资源
    public static void close(Statement stmt,Connection connection) throws SQLException {
        if(stmt!=null){
            stmt.close();
        }
        if(connection!=null){
            connection.close();
        }
    }
    public static void close(ResultSet rs,Statement stmt,Connection con) throws SQLException {
        close(stmt,con);
        if(rs!=null){
            rs.close();
        }
    }



}
