package itcast.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( "/responseDemo3")
public class ResponseDemo3 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*在获取流对象之前，设置流编码为GBK*/
        response.setCharacterEncoding("utf-8");
        //告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用该编码解码
        //response.setHeader("content-type","text/html;charset=utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取字符输出流
        PrintWriter pw=response.getWriter();
        //输出数据
      /*  pw.write("<h1>hello response </h1>");*/
        pw.write("你好");
        /*乱码原因，编码解码使用的字符集不一致
               windows浏览器客户端 字符集，默认使用GBK(gb2312)
                写代码时用tomcat获取writer的编码为ISO-8859-1   所以在获取流对象之前，设置流编码为GBK
                        //告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用该编码解码*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
