package Java新特性.注解;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

//框架类  可以执行任意类的方法 对象

@Pro(className = "Java新特性.注解.Demo1",methodName = "show")
public class ReflectTest {


     public static void main(String args[]){


        /*前提： 不能改变该类的任何代码，可以创建任意类的对象，可以执行任意方法*/
        //1、解析注解
        //1.1获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass=ReflectTest.class;
        System.out.println(reflectTestClass.getName());
        //2、获取上边的注释对象
        ////其实就是在内存中生成了一个该注解接口的子类实现对象

        Pro annotation = reflectTestClass.getAnnotation(Pro.class);

      // 原理如下：  必须声明引言的属性@Retention(RetentionPolicy.RUNTIME)
        /* public class proImpl implements Pro{
            public String clasName(){
                return "Java新特性.注解.Demo1";
            }
            public String methodName(){
                return "show";
            }
        }*/


        //调取直接对象中定义的抽象方法，获取其返回值
        String classname=annotation.className();
        String methodName = annotation.methodName();
        System.out.println(classname);
        System.out.println(methodName);

    }

}
