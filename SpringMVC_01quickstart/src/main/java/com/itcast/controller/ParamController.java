package com.itcast.controller;


import com.itcast.domain.Account;
import com.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//请求参数绑定
@Controller
@RequestMapping("/param")
public class ParamController
{
    /**
     * 请求参数绑定
     */
    @RequestMapping("/testParam")
    public String testParam(String username){
        System.out.println("执行了");
        System.out.println("用户名"+username);
        return "success";
    }


    /**
     * 把数据封装到javabean的类中
     *
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("执行了");
        System.out.println(account);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println("执行了");
        System.out.println(user);
        return "success";
    }

    /**
     * 测试Servlet原生的API
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了");
        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        System.out.println(response);
        return "success";
    }

}
