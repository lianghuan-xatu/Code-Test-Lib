package Web.Servlet;

import Domain.User;
import Service.Impl.UserServiceImpl;
import Service.UserService;

import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet("/userListServlet")
public class userListServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //调用UserService完成查询
        UserService userService = new UserServiceImpl();
        List<User> users = userService.findAll();
        //将List存入request域中
        request.setAttribute("users",users);
        //转发到页面
        String contextPath = request.getContextPath();
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
