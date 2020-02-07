package Java新特性;

public class 自动装箱和自动拆箱 {
    public static void main(String[] args){


    }
    public void fun1(){
        Integer i=10;   //自动装箱：Integer i=Integer.valueOf(10);
        // Integer i=Integer.valueOf(10);
    }
    public void fun2() {
        int i=new Integer(10);
        //Integer i1=new Integer(10); //自动拆箱 ：//int i2=i1.intValue();
        //int i2=i1.intValue();
    }
    public void fun3(){
        int i1=new Integer(100);
        int i2=new Integer(100);
        System.out.println(i1==i2);  //i1!=i2//    false    在不同的内存空间
        Integer i3=100;
        System.out.println(i3==i1);//false;
        Integer i4=100;
        System.out.println(i3==i4); //true;     查看源代码  -128到127之间直接取缓存数组    其他开辟内存创建
        Integer i5=200;
        Integer i6=200;
        System.out.println(i5==i6);  //false
    }//通过反编译可以得到其原理    自动装箱和自动拆箱


}
