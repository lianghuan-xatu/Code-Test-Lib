package itcast.web.Session.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet2")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取参数Map
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        //先判断验证码是否正确
        HttpSession session = request.getSession();
        String checkCode1 = (String) session.getAttribute("checkCode");
        //删除session中存储的验证码
        session.removeAttribute("checkCode");

        if(checkCode1!=null&&checkCode1.equalsIgnoreCase(checkCode)){
            //忽略大小写比较字符串
            //验证码正确
            //判断用户名密码是否正确
            if("zhangsan".equals(username)&&"123".equals(password)){
                //需要调用UserDao查询数据库
                //登录成功
                //存储信息，用户信息
                //重定向到success.jsp
                session.setAttribute("user",username);
                response.sendRedirect(request.getContextPath()+"/success.jsp");

            }else{
                //登录失败
                request.setAttribute("login_error","用户名或密码错误");
                //转发到登陆页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }

        }else{
            //验证码不一致
            //存储信息到request
            request.setAttribute("cc_error","验证码错误");
            //转发到登陆页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
