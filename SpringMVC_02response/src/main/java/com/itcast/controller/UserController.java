package com.itcast.controller;

import com.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController
{
    /**
     * 返回字符串
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("执行了");
        //模拟从数据库中查询出User对象
        User user=new User();
        user.setUsername("梁欢");
        user.setAge(20);
        user.setPassword("lh20010326");
        //model对象
        model.addAttribute("user",user);
        return "success";
    }

    /**
     *返回void
     * 请求转发一次请求，不用编写项目名字
     * @param
     * @return
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行了");
        //编写请求转发程序
        request.getRequestDispatcher("pages/success.jsp").forward(request,response);
        //重定向
        response.sendRedirect(request.getContextPath()+"pages/success.jsp");
        //直接进行响应
        //设置编码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8;");
        response.getWriter().write("hello");
    }


}
