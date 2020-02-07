package Java新特性;

import org.junit.Test;

public class 变长参数 {
    public static void main(String[] args){


    }
    public static int add(int a,int b){
        return a+b;
    }
    public static int add(int a,int b,int c){
        return a+b+c;
    }
    public static int add(int a,int b,int c,int d){
        return a+b+c+d;
    }
    public static int add(int[] arr){
        int result=0;
        for(int a:arr){
            result+=a;
        }
        return result;
    }//////变长参数的原理
    public static int add2(int...arr){
        int result=0;
        for(int a:arr){
            result+=a;
        }
        return result;
    }
    @Test
    public void fun1(){
        System.out.println(add2(2,4,5,6,8));
        System.out.println(add2(5,6,8));
    }
//通过反编译得到原理就是通过传入数组运算
//自动创建数组  封装参数
      //注意：  1、可变参数必须作为方法的最后一个参数
          //      2、一个方法中只能使用一次变长参数
}
