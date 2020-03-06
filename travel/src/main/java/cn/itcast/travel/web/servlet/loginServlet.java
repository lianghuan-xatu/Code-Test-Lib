package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("loginServlet");
        //验证校验
        String check = request.getParameter("check");
        //从session 中获取验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
        //为了保证验证码只能使用一次
        session.removeAttribute("CHECKCODE_SERVER");
        //比较
        if(checkcode_server==null||!checkcode_server.equalsIgnoreCase(check)){
            //验证码错误
            System.out.println("验证码错误");
            ResultInfo info=new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            //将info对象序列化成json
            ObjectMapper mapper=new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            //将json数据写回客户端
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }

        //获取用户名和密码数据
        Map<String, String[]> map = request.getParameterMap();
        //封装user对象
        User user=new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service查询
        UserService service=new UserServiceImpl();
        User u=service.login(user);
        ResultInfo info=new ResultInfo();
        //判断用户对象是否为null
        if(u==null){
            info.setFlag(false);
            info.setErrorMsg("用户名密码或错误");
        }
        //判断是否激活
        if(u!=null&&!"Y".equals(u.getStatus())){
            //用户尚未激活
            info.setFlag(false);
            info.setErrorMsg("您尚未激活，请登录邮箱激活");

        }
        //判断登陆成功
        if(u!=null&&"Y".equals(u.getStatus())){

            session.setAttribute("user",u);
            info.setFlag(true);
        }
        //响应数据
        ObjectMapper mapper=new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
