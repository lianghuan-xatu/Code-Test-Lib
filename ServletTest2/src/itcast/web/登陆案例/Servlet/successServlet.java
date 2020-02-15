package itcast.web.登陆案例.Servlet;

import itcast.web.登陆案例.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class successServlet extends HttpServlet
{

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            User user = (User) request.getAttribute("user");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(user.getUsername()+"登录成功！");
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
        }
    }

