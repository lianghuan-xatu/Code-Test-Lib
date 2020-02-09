package Java新特性.注解;

import java.lang.annotation.*;

/*元注解：用于描述注解的注解
@Target:描述注解能够作用的位置
    ElementType取值：  type  作用在类上   method 方法上   field作用在成员变量上
@Retention：描述注解被保留的阶段
    @Retention(RetentionPolicy.RUNTIME)当前被描述的注解，会保留到Class字节码文件中，并被JVM读取到
@Documented：描述注解是否被抽取到api文档中
@Inherited：描述注解是否被子类继承
*/
@Target(value = {ElementType.TYPE})  //表示该注解只能用于类上
@Retention(RetentionPolicy.RUNTIME)
@Documented    // 可被抽取成api文档
@Inherited    //继承者继承父类注解
public @interface MyAnno3 {

}
