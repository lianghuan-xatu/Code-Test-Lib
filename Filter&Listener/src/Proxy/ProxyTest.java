package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String args[]){
        //创建真实对象
        Lenovo lenovo=new Lenovo();

        //动态代理增强lenovo对象
        /**
         * 三个参数：
         *      1、类加载器：真实对象.getClass().getClassLoader()
         *      2、接口数组：真实对象getClass().getInterfaces()
         *      3、处理器：new InvocationHandler()
         *
         *
         */
        //类型强转
        SaleComputer proxy_lenovo =(SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 代理逻辑编写的方法：代理对象调用的所有方法 都会触发该方法执行
             * @param proxy 代理对象
             * @param method  代理对象调用的方法，被封装成对象
             * @param args 代理对象调用的方法时，传递的实际参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               /* System.out.println("该方法执行了");*/
                //判断是否是sale方法
                if(method.getName().equals("sale")){
                    //1、增强参数
                    double money= (double) args[0];
                    money=money*0.85;
                    System.out.println("专车接你");  //增强方法体
                    //使用真实对象调用该方法
                    String obj = (String) method.invoke(lenovo, money);
                    System.out.println("免费送货");
                    //增强返回值
                    return obj+"鼠标垫和键盘大礼包";
                }else {

                    Object obj = method.invoke(lenovo, args);
                    return obj;

                }
            }
        });

        //调用方法
        String computer=proxy_lenovo.sale((double) 8000);
        System.out.println(computer);
        
        }
}
