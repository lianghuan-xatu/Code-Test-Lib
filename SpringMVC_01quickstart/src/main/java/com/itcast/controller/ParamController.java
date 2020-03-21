package com.itcast.controller;


import com.itcast.domain.Account;
import com.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
