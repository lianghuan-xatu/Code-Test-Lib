package Java新特性.注解;

import static org.junit.Assert.*;
/*定义了属性，在使用时需要给属性赋值
    1、如果定义属性时，使用default关键字给属性默认初始化值，则使用注解时可以不进行属性的赋值
    2、如果只有一个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可
    3、数组赋值时，值使用{}包裹。如果数组中只有一个值，则{}可以省略*/
@MyAnno2(name = "张三", show = 2, show2 = "深度", per = Person.P1, anno =@MyAnno3, ann ={"abc","bnv"} )
@MyAnno3
public class WorkerTest {

}