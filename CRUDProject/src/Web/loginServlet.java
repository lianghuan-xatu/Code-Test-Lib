package Web;

import Domain.User;
import Service.Impl.UserServiceImpl;
import Service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/loginServlet")
public class
loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取数据
            //获取用户填写的验证码
        String verifycode = request.getParameter("verifycode");
        //验证码检验
        HttpSession session = request.getSession();
        String checkCode = (String) session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        if(!checkCode.equalsIgnoreCase(verifycode)){
            //验证码不正确
            //提示信息   跳转登录页面
            request.setAttribute("login_msg","验证码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        //封装User对象
        User user=new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用Service查询
        UserService userservice=new UserServiceImpl();
        User loginUser = userservice.login(user);
        //判断是否登录成功
        if (loginUser!=null){
            //登陆成功  将用户存入sesssion
            session.setAttribute("user",loginUser);
            response.sendRedirect(request.getContextPath()+"/index.jsp");


        }else{
            //登陆失败
            //提示信息
            request.setAttribute("login_msg","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
