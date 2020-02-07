package Java新特性;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 泛型 {
    List<String> list=new ArrayList<String>();   //泛型写法
    List list2=new ArrayList();  //普通写法
    //使用泛型的优势 ：    在集合上贴标签  只能放入对应类型
    //1、省去了大部分的强转操作
    //2、将运行时期的错误提前到编译时期
    //3、使用泛型安全性较高



    //一个类可以定义多个泛型  一般从业务上不超过两个
  @Test
    public void fun(){
      Bag<String> bag=new Bag<>();
      bag.setObj("tom");
      System.out.println(bag.getObj());
  }

  //定义泛型方法时，泛型变量声明在方法返回值之前
    public static <T> T echo(T obj){
      return obj;
    }
    @Test
    public void fun2(){
      //显示指定泛型类型
        //Demo.<String>echo("hello");
        //隐式指定泛型类型
        //Demo.echo(new Demo());

    }
}
