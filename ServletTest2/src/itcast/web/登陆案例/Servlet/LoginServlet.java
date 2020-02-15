package itcast.web.登陆案例.Servlet;

import itcast.web.登陆案例.User;
import itcast.web.登陆案例.UserDAO;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置编码
        req.setCharacterEncoding("utf-8");
        //获取请求参数
       /* String username=req.getParameter("username");
        String password=req.getParameter("password");
        User loginuser=new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);*/
        //调用UserDAO的login方法
        //获取所有请求参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        //创建login对象
        User loginuser=new User();
        try {
            BeanUtils.populate(loginuser,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserDAO dao=new UserDAO();
        User user = null;
        try {
            user = dao.login(loginuser);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //判断user
        if(user==null){
            //登陆失败
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else{
            //登陆成功
            //存储数据
            req.setAttribute("user",user);
            //转发
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req,resp);
    }
}
