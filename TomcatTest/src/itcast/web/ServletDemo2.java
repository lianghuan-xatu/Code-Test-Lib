package itcast.web;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo2 implements Servlet {
//    Servlet中的生命周期
 //   Servlet的方法
 /*   Servlet什么时候被创建？
    默认情况下，第一次被访问时创建
    可以配置执行Servlet的创建实际
    在web.xml的配置文件中增加在servlet下
    */
     /* 指定Servlet的创建时机
       1、第一次被访问时，创见
       <load-on-startup>的值为负数
        2、在服务器启动时，创建
        <load-on-startup>的值为0或正数*/
     //Servlet的init方法，只执行一次，说明一个Servlet在内存中只存在一个对象，Servlet是单例的
        //对各用户同时访问时，可能存在线程安全问题。
        //解决：尽量不要在Servlet中定义成员变量   即使定义了成员变量也不要对其修改值   才不会出现数据安全问题
/*
    提供服务：执行service方法，执行多次
     *每次访问Servlet时，Service方法都会被调用一次
    被销毁：执行destroy方法执行一次
    *Servlet被销毁时执行，服务器关闭时，Servlet被销毁
    *只有服务器正常关闭时，才会执行destroy方法
    *destroy方法在Servlet被销毁之前执行，一般用于释放资源
    **/
    /**
     * 初始化方法，在Servlet被创建时执行，只会执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init....");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务方法
     * 每一次Servlet被访问时执行，执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service....");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务器正常关闭时执行
     */
    @Override
    public void destroy() {
        System.out.println("destroy....");
    }
}




