package itcast.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/*
Servlet快速入门

        Servlet   :server  applet
        概念：运行在服务器上的小程序
        servlet 就是一个接口，定义了java类被浏览器访问到（tomcat识别）的规则
        将来我们自定义一个类，实现servlet接口，复写方法

        1、创建JavaEE项目
        2、定义一个类实现Servlet接口
        3、实现接口中的抽象方法
        4、配置Servlet  在web路径下的web.xml中
*/
/*执行原理：
1、当服务器接收到浏览器的请求之后，会解析请求URL路径，获取访问的servlet的资源路径
2、查找web.xml文件，是否有对应的<url-pattern>标签体内容
3、如果有再找到对印的<servlet-class>全类名
4、tomcat会将字节码文件加载进内存，并且创建对象
5、调用其方法*/


public class ServletDemo1 implements Servlet
{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //提供服务的方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
