package Java新特性.注解测试框架;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
简单的测试框架
    当主方法执行后，会自动执行被检测的所有方法（加了Check注解的方法）  判断方法是否有异常
*/
public class TestCheck {
    public static void main(String args[]) throws IOException {
        //创建计算器对象
        Calculator c=new Calculator();
        //获取字节码文件
        Class cls=c.getClass();
        //获取所有方法
        Method[] methods=cls.getMethods();
        int number=0;//出现异常的次数
        BufferedWriter bw=new BufferedWriter(new FileWriter("bug.txt"));

        //判断方法上是否含有Check注解
        for(Method method :methods){
            if(method.isAnnotationPresent(Check.class)){
                try {
                    method.invoke(c);
                } catch (Exception e) {
                 number++;
                 //记录到文件
                    bw.write(method.getName()+"方法出现异常了");
                    bw.newLine();
                    bw.write("异常的名称："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因："+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("-----------------------------");
                    bw.newLine();
                }

            }

        }
        bw.write("本次测试发现了"+number+"个异常");
        bw.newLine();
        bw.flush();
        bw.close();
        }
}



//以后多数时候，我们会使用注解，而不是自定义注解
/*
  注解给谁用：    编译器和解析程序用
注解不是程序的一部分，可以理解为注解就是一个标签*/
