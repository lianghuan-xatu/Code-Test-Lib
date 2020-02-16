package itcast.web.response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletContextDemo3")
public class ServletContextDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*共享数据
        1、setAttribute(String name,Object value);
        2、getAttribute(String name)
        3、removeAttribute(String name)
                *ServletContext对象范围，所有用户所有请求的数据*/
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("msg","haha");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
