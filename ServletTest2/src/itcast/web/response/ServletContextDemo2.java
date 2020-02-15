package itcast.web.response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       /* 功能：
        1、获取MIME类型
                *MIME类型：在互联网通信过程定义的一种文件数据结构
                *格式：大类型/小类型   text/html     image/jpeg

        2、域对象：共享数据
        3、获取文件的真实（服务器）路径*/
        ServletContext servletContext = this.getServletContext();
        //定义文件名称
        String filename="a.jpg";
        //获取MIME类型
        String mimeType = servletContext.getMimeType(filename);
        System.out.println(mimeType);   //image/jpeg
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
