package itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*演示获取Request对象请求行数据*/


@WebServlet( "/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        String method = req.getMethod();
        System.out.println(method);
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        String servletPath = req.getServletPath();
        System.out.println(servletPath);
        String queryString = req.getQueryString();
        System.out.println(queryString);
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);
        String protocol = req.getProtocol();
        System.out.println(protocol);
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
 //       1、获取请求方式：GET
//                *String getMethod
//                * 2、获取虚拟目录：/day14
//                *String getContextPath()
//        3、获取Servlet路径：/demo1
//                *String getServletPath()
//        4、获取get请求方式请求参数：name=zhangsan
//                *String getQueryString()
//                * 5、获取请求URI：/day14/demo1
//                *String getRequestURI():  /day14/demo1
//                *StringBuffer getRequestURL():  http://localhost/day14/demo1
//        6、获取协议及版本：HTTP/1.1
//                *String getProtocol()
//        7、获取客户机的IP地址：
//                            *String getRemoteAddr()
//        

    }
}
