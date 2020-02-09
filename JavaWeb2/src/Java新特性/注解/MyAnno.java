package Java新特性.注解;
//自定义注解
public @interface MyAnno {
}
//经过反编译  得到本质：

/*
public interface MyAnno extends java.lang.annotation.Annotation{

}*/
