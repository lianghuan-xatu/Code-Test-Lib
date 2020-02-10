package itcast.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


/*
Servlet 3.0：
        好处： 支持注解配置，可以不需要web.xml了
        步骤：
        1、创建Java EE项目，选择Servlet的版本3.0以上，可以不创建web.xml
        2、定义一个类，实现Servlet接口
        3、重写方法
        4、在类上使用@webServlet注解，进行配置
        urlPatterns和value一样
        在开启第二个Sevlet时必须先关闭第一个Deploy项目才能访问
*/

@WebServlet(name = "ServletTest",urlPatterns = "/demo3")
public class ServletDemo implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
            System.out.println("service..../..........");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
