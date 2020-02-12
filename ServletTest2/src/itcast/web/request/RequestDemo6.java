package itcast.web.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/requestDemo6")
public class RequestDemo6 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("demo6被访问了  ");
        //存储数据到request域中
        req.setAttribute("data","hello");
        //跳转到demo9资源
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/requestDemo7");
        requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      this.doPost(req,resp);

    }
}
