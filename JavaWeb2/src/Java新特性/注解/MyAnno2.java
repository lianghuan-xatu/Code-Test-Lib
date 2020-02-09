package Java新特性.注解;
//注解的属性：接口中的抽象方法
//要求；
/*属性的返回值：
   *基本数据类型
   *String
   *枚举
   *注解
    *以上类型的数组    */
public @interface MyAnno2 {
    /*public abstract*/
    String name();
    String name2() default "张三"; // 默认值：张三
   // 如果一个属性需要赋值，并且属性类型名称为value  则value可以省略，直接定义即可
    int show();
    String show2();
    Person per();
    MyAnno3 anno();
    //以上类型的数组
    String[] ann();

}
