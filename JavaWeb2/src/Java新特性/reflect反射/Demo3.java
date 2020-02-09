package Java新特性.reflect反射;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Demo3
{
    @Test
    public void fun() throws ClassNotFoundException, NoSuchMethodException {
        Class clazz3=Class.forName("Java新特性.reflect反射.Car");
        Method m1=clazz3.getMethod("run");
        //获得Method可以做什么？
            //描述信息
            //修饰符
        System.out.println(Modifier.toString(m1.getModifiers())); //public
            //返回值
        System.out.println(m1.getReturnType().getName());  //void
            //方法名
        System.out.println(m1.getName());   //run
            //参数列表
        System.out.println(m1.getParameterTypes().length);   //0
            // 抛出异常
        System.out.println(m1.getExceptionTypes().length);   //2

    }
    @Test
    public void fun2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz3=Class.forName("Java新特性.reflect反射.Car");
        Method m1=clazz3.getMethod("setColor", String.class);
        //使用方法可以做什么？
        Car car=new Car();
        System.out.println(m1.invoke(car,"blue"));//null
        System.out.println(car.getColor()); //blue
        //------私有方法调用----setAcessable(true)
        //------静态方法调用-----不需要对象    //m1.invoke(null);




    }
}
