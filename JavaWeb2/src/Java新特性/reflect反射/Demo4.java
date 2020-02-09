package Java新特性.reflect反射;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Demo4
{
    @Test
            public void fun() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class clazz3=Class.forName("Java新特性.reflect反射.Car");
        Field f1=clazz3.getField("desc");
        //获得Field可以做什么？
        //使用属性可以做什么？
        Car car=new Car();
        f1.set(car,"haha");
        System.out.println(f1.get(car));

        //------操作静态属性
 /*       Field f2=clazz3.getField("desc");
        f2.set(null, "haha");
        System.out.println(f2.get(null));//haha*/





        //描述信息
        //修饰符
        System.out.println(Modifier.toString(f1.getModifiers()));
        //返回值
        System.out.println(f1.getType().getName());  //String
        //方法名
        //参数列表
        //抛出异常

    }

}
