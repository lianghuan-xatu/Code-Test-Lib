package Java新特性.reflect反射;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class Demo2
{
    @Test
    public void fun() throws ClassNotFoundException, NoSuchMethodException {
        Class clazz3=Class.forName("Java新特性.reflect反射.Car");

        Constructor con1=clazz3.getConstructor(String.class);  //指定参数获得构造方法
        Constructor[] cons=clazz3.getConstructors();
        System.out.println(con1.getName());
        System.out.println(cons.length);
        //获得私有构造方法
        Constructor con2=clazz3.getDeclaredConstructor(String.class,String.class);
        Constructor cons2[]=clazz3.getDeclaredConstructors();
        System.out.println(cons2.length);   //3


        //
    }
    @Test
    public void fun2() throws ClassNotFoundException, NoSuchMethodException {
        Class clazz3=Class.forName("Java新特性.reflect反射.Car");
        Constructor con1=clazz3.getConstructor(String.class);  //指定参数获得构造方法   public Car(String color){
    //    this.color=color;
  //  }
        //获得Constructor可以做什么？
        //1、描述信息
            //限定名称
        System.out.println(Modifier.toString(con1.getModifiers()));
            //构造方法名称
        System.out.println(con1.getName());
            //参数列表
        Class[] ps=con1.getParameterTypes();
        System.out.println(ps.length);
            //获得抛出异常信息
        Class[] es=con1.getExceptionTypes();
        System.out.println(es.length);
        System.out.println(es[0].getName());
        
        

    }
    @Test
    public void fun4() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz3=Class.forName("Java新特性.reflect反射.Car");
        Constructor con1=clazz3.getConstructor(String.class);

        //2、根据构造函数创建实例
        Car car=(Car)con1.newInstance("yellow");
        System.out.println(car.getColor());
        Constructor con2=clazz3.getDeclaredConstructor(String.class,String.class);
        //私有构造函数调用
        con2.setAccessible(true);//con2为private    设置con2为可访问类型  但是不推荐  破坏封装性
        Car car2= (Car) con2.newInstance("a","b");
    }

}
