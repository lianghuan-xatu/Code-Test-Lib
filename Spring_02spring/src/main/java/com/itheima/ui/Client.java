package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     * 获取spring的Ioc核心容器，根据id获取对象
     * @param args
     */
    /**
     * ApplicationContext的三个常用实现类 ：
     *          ClassPathXmlApplicationContext:它可以加载类路径下的配置文件，不在的话无法加载
     *          FileSystemXmlApplicationContext:它可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *          AnnotationConfigApplicationContext:他是用于读取注解创建的容器的
     *
     * 核心容器的两个接口引发的问题 ：
     *      ApplicationContext：      单例对象使用  一般采用此接口
     *              它在构建核心容器时，创建对象采用的策略是采用立即加载的方式，也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象
     *     BeanFactory：       多例对象使用
     *              它在构建核心容器时，创建对象采用的策略是采用延迟加载的方式，也就是说，什么时候根据id获取对象了，什么时候真正的创建对象
     *
     *
     *
     * @param args
     */

    public static void main(String[] args) {

        //获取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
    //    ApplicationContext ac=new FileSystemXmlApplicationContext("C:\\Users\\zachary\\Desktop\\bean.xml");
        //根据id获取Bean对象
        IAccountService as= (IAccountService) ac.getBean("accountService");
        IAccountDao adao=ac.getBean("accountDao",IAccountDao.class);  //让核心容器帮我们强转类型
        System.out.println(as);
        System.out.println(adao);

        //-----------------BeanFactory----------------
    /*    Resource resource=new ClassPathResource("bean.xml");
        BeanFactory factory=new XmlBeanFactory(resource);
        IAccountService as2= (IAccountService) factory.getBean("accountService");
        System.out.println(as2);
        */



//        IAccountService as = new AccountServiceImpl();
//        for(int i=0;i<5;i++) {
//
//            System.out.println(as);
//            as.saveAccount();
        }

    }

