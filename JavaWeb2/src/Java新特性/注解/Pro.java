package Java新特性.注解;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Pro {
    String className();
    String methodName();
}
