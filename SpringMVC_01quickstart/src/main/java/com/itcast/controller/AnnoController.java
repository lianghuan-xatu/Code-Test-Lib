package com.itcast.controller;

import com.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

//控制器
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})  //把msg=梁欢存入到session域对象中
public class AnnoController
{
    /**
     * 请求数据映射
     * @param username
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println("执行了");
        System.out.println(username);
        return "success";
    }

    /**
     * 获取请求体
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了");
        System.out.println(body);
        return "success";
    }


    /**
     * PathVariable注解
     * @param
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(name = "id")String id){
        System.out.println("执行了");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头
     * @param
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String requestHeader){
        System.out.println("执行了");
        System.out.println(requestHeader);
        return "success";
    }


    /**
     * 获取Cookie的值
     * @param
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("执行了");
        System.out.println(cookieValue);
        return "success";
    }


    /**
     * ModelAttribute注解
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("adc") User user){
        System.out.println(user);
        return "success";
    }

    /**
     * 该方法会先执行
     *//*
    @ModelAttribute
    public User showUser(String uname){
        //通过用户名查询数据库
        User user=new User();
        user.setName(uname);
        user.setAge(18);
        user.setDate(new Date());
        System.out.println("showUser执行了");
        return user;
    }
*/
    @ModelAttribute
    public void showUser(String uname, Map<String,User> map){
        //通过用户名查询数据库
        User user=new User();
        user.setName(uname);
        user.setAge(18);
        user.setDate(new Date());
        map.put("abc",user);
    }


    /**
     * testSessionAttributes注解
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        model.addAttribute("msg","梁欢");   //底层会存储到request域对象中
        System.out.println("testSessionAttributes....");
        return "success";
    }

    /**
     * 从Session域中取值
     * @param modelMap
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        System.out.println("getSessionAttributes....");
        return "success";
    }


    /**
     * 从Session域中清除
     * @param
     * @return
     */
    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        status.setComplete();
        return "success";
    }


}
