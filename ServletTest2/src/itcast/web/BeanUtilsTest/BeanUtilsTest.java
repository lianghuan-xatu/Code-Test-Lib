package itcast.web.BeanUtilsTest;

import itcast.web.登陆案例.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {
    @Test
    public void test(){
        User1 user=new User1();
        try {
            BeanUtils.setProperty(user,"username","zhangsan");
            BeanUtils.setProperty(user,"hehe","true");   //是按照属性设置的所以gender该边  而不是按照成员变量
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);

    }
   
}
