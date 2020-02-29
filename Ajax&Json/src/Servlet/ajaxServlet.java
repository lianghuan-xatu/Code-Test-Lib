package Servlet;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/ajaxServlet")
public class ajaxServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            //1、获取请求参数
        String username = request.getParameter("username");
         //处理业务逻辑  耗时
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //2、打印username
        System.out.println(username);
        //3、响应
        response.getWriter().write("hello:"+username);


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
