package Java新特性;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class 增强for循环 {
    @Test
    public void fun() {
        List list = new ArrayList();
        list.add("java");
        list.add("php");
        list.add(".net");

        for (Object obj : list) {
            System.out.println(obj);
        }
    }//反编译之后 ：
      /*  Object obj;
        for(Iterator iterator=list.iterator();iterator.hasNext();System.out.println(obj))
            obj=iterator.next();
*/
      @Test
      public void fun2(){
        int arr[]=new int[]{1,2,3,4,5};
        for(int a:arr) {
            System.out.println(a);
        }
    }
        @Test
    public void fun3(){
          MyIt it=new MyIt();
          for(Object o:it){
              System.out.println(o);
          }
        }


}
    //增强for循环：  遍历数组，实现了接口，Iterable<T>接口
    //原理：
    //数组---》普通for循环
    //Iteable---> 使用迭代器遍历
    //使用增强for循环没有提高遍历效率   因为编译之后还是使用的传统遍历方式遍历
    //为什么要用？？？    书写简单
    //缺点 ：
// 在遍历时没有索引的概念
// 不能对数组/集合进行操作
//不能对数组/集合中的某一段进行遍历，只能从头遍到尾