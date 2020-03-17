package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * 该类是一个配置类，它的作用和bean.xml是一样的
 * Spring中的新注解
 * Configuration
 *          作用：指定当前类是一个配置类
 *          细节：当配置类作为AnnotationConfigration的参数传入时可以不用写
 *
 *          ComponentScan
 *              作用：用于通过注解指定spring在创建容器时要扫描的包
 *              属性：   value：它和basePackages的作用是一样的，都是用于指定创建容器时要扫描的包
 *                              我们使用此注解就等同于在xml配置了:  <context:component-scan base-package="com.itheima"></context:component-scan>
 * @Bean
 *      作用：用于把当前方法的返回值作为bean对象存入spring的IOC容器中
 *      属性：    name：用于指定bean的id。当不写时，默认值是当前方法的名称
 *      细节：
 *              当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象
 *              查找方式和AutoWired注解的作用是一样的
 *  Import
 *         作用：用于导入其他配置类
 *         属性:
 *          value:用于指定其他配置类的字节码文件
 *          当我们使用Import的注解之后，有Import注解的类就父配置类，而导入的其他就是子配置类
 *   对于其他子配置类  要么配置Configuration注解再从主配置文件扫描包  要么以参数形式变参传入   要么在主配置文件中导入
 *
 *   PropertySource
 *          作用：用于指定properties文件的位置
 *          属性：
 *                  value：指定文件的名称和路径
 *                  关键字：classpath  表示类路径下
 */
//@Configuration
@Import(JdbcConfig.class)
@ComponentScan(basePackages = {"com.itheima"})
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(@Qualifier("dataSource1") DataSource dataSource) {
        //如果存在两个相同类型数据源时@Qualifier("dataSource1")
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源对象
     *
     * @return
     */
    @Bean(name = "dataSource1")
    public DataSource createDataSource() {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/eesy");
            ds.setUser("root");
            ds.setPassword("12345678");
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 创建数据源对象
     *
     * @return
     */
    @Bean(name = "dataSource2")
    public DataSource createDataSource2() {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/eesy");
            ds.setUser("root");
            ds.setPassword("12345678");
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}