package Java新特性.reflect反射;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

//框架类  可以执行任意类的方法 对象呢
public class ReflectTest {
    public static void main(String args[]) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        创建任意类的对象，可以执行任意方法
//                这个框架在不改变代码情况下帮我们创建对象并执行方法
//
/*实现：  配置文件  反射
                步骤：
                    1、将需要你创建的对象的全类名和需要执行的方法定义在配置文件中
                    2、在程序中加载读取配置文件
                    3、使用反射技术来加载类文件进内存
                    4、创建对象
                    5、执行方法
                */
      /*  Car car1=new Car();
        car1.run();
       */
        //1、加载配置文件
        //1.1、创建Properties对象
        Properties pro = new Properties();
        //1.2、加载配置文件，转换为一个集合
        //1.2.1获取class目录下的配置文件
       ClassLoader classloader=ReflectTest.class.getClassLoader();
       InputStream is=classloader.getResourceAsStream("pro.properties");
       pro.load(is);
       //获取配置文件中定义的数据
        String className=pro.getProperty("classname");
        String methodName=pro.getProperty("methodName");
    //3\加载该类进内存

            Class cls= Class.forName(className);
        //4\创建对象
        Object obj=cls.newInstance();
   //5、获取方法对象
        Method method=cls.getMethod(methodName);
        //执行方法
        method.invoke(obj);

    }
}
