package itcast.web.response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletDemo1")
public class ServletContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* 1、通过request对象获取
        reques.getServletContext();
        2、通过HttpServlet获取
        this.getServletContext();*/
        ServletContext servletContext =request.getServletContext();
        ServletContext servletContext1 = this.getServletContext();
        System.out.println(servletContext);
        System.out.println(servletContext1);
        System.out.println(servletContext==servletContext1);   //true
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
