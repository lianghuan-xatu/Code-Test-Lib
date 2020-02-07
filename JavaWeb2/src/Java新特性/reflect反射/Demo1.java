package Java新特性.reflect反射;

import org.junit.Test;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Demo1
{
    @Test
    public void fun() throws Exception {
        //获取Class的方式
        //根据实例获得
        Car car=new Car();
        Class clazz1=car.getClass();
        //根据类获得
        Class clazz2=Car.class;
        //根据完整类名
        Class clazz3=Class.forName("Java新特性.reflect反射.Car");
    }
    @Test
    public void fun1() throws Exception{
        Class clazz3=Class.forName("Java新特性.reflect反射.Car");
        //获得Class可以做什么？
        //获得类中的信息
           //获得类名
        String name1=clazz3.getName();
        String name2=clazz3.getSimpleName();//简单类名
        System.out.println(name1);
        System.out.println(name2);
           //获得类的修饰符
       System.out.println(Modifier.toString(clazz3.getModifiers()));
            //类的父亲，接口
        System.out.println(clazz3.getSuperclass().getName());
        System.out.println(clazz3.getInterfaces().length); //接口数
            //获得类中的构造
        //以下两个不能获得私有构造方法
        Constructor con1=clazz3.getConstructor(String.class);  //指定参数获得构造方法
        Constructor[] cons=clazz3.getConstructors();
        System.out.println(con1.getName());
        System.out.println(cons.length);
        //获得私有构造方法
        Constructor con2=clazz3.getDeclaredConstructor(String.class,String.class);
        Constructor cons2[]=clazz3.getDeclaredConstructors();
        System.out.println(cons2.length);   //3
            //获得类中的变量/字段
        Field f1=clazz3.getField("color");
        Field[] fs1=clazz3.getFields();
        System.out.println(f1.getName());   //desc
        System.out.println(fs1.length); //1
        //获得公有属性
        Field f2=clazz3.getDeclaredField("color");
        Field fs2[]=clazz3.getDeclaredFields();
        System.out.println(f2.getName());
        System.out.println(fs2.length);
        // 获得类中的方法
        //获得类中所有公有方法（包含继承方法）
        Method m1=clazz3.getMethod("run");
        Method[] ms1=clazz3.getMethods();
        System.out.println(m1.getName());  //run
        System.out.println(ms1.length);   //13
        //获得类中的方法   (包括私有方法不包括继承方法）
        Method m2=clazz3.getDeclaredMethod("getDesc");
        Method ms2[]=clazz3.getDeclaredMethods();
        System.out.println(m2.getName());  //getDesc
        System.out.println(ms2.length);   //3
        //创建实例

    }
    @Test
    public void fun3() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz3=Class.forName("Java新特性.reflect反射.Car");
        //创建实例
        Car car=(Car) clazz3.newInstance();
        car.run();
        //注意： 使用类的  newInstance 方法只能调用空参数
    }
}
