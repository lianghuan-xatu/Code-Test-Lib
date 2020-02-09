package Java新特性.注解;
//注解演示
/**@author itcast
 * @version 1.5
 * @since 1.5
 */
public class AnnotationDemo {
    /**
     * 计算两数之和
     * @param a 整数
     * @param b 整数
     * @return 两数之和
     */
    public int add(int a,int b){
        return a+b;
    }
}
/*
  作用分类
    1、编写文档：通过代码里标识的注解生成文档【生成doc文档】 使用命令行工具javadoc  文件   生成相关api文档
    2、代码分析：通过代码里标识的注解进行分析  使用反射
    3、编译检查：通过代码里标识的注解让编译器能够实现基本的编译检查   override*/
//JDK中预定义的一些注解
   /* @override:检测被标注方法是否是继承自父类接口
    @Deprecated:该注解标注的内容，标识已过时
    @SuppressWarnings:压制警告*/
//自定义注解
//在程序中（解析）注解
@SuppressWarnings("all") //压制所有警告   不会出现警告
class Test{
    @Override
    public String toString() {
        return super.toString();
    }
    @Deprecated
    public void show1(){

    }
    public void show2(){
        //代替show1方法
    }
    public void demo(){
        show1();

    }

}
