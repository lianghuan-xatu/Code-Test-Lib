package com.itcast.controller;

import com.itcast.domain.User;
import com.itcast.exception.sysException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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


  @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect");
        //请求转发
       // return "forward:/pages/successjsp";
        //重定向
      return "redirect:/index.jsp";//框架底层会自动加项目目录

    }

    /**
     * 返回ModelAndView
     * @return
     */
    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        //创建ModelAndView对象
        ModelAndView mv=new ModelAndView();
        System.out.println("testModelAndView");
        //模拟从数据库中查询到User对象
        User user=new User();
        user.setUsername("张三");
        user.setAge(34);
        user.setPassword("43543543");
        //把user对象存储到mv对象  他底层也会把user对象存入到request对象
        mv.addObject("user",user);
        mv.setViewName("success");
        return mv;
    }
/*

    *//**
     * 模拟异步请求响应
     *//*
    @RequestMapping("testAjax")
    public void testAjax(@RequestBody String body){
        System.out.println("testAjax...");
        System.out.println(body);

    }*/

    /**
     * 模拟异步请求响应
     */
    @RequestMapping("testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax...");
        //客户端发送Ajax请求，传的是json数据字符串，后端将json字符串封装到user对象中
        System.out.println(user);
        //做出响应，模拟查询数据库
        user.setUsername("hhaa");
        user.setAge(100);
        return user;
    }


    /**
     * 文件上传
     */
    @RequestMapping("/fileload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传...");
        //使用fileupload组件完成文件上传
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        //判断该路径是否存在
        File file=new File(path);
        if(!file.exists()){
            //创建文件夹
            file.mkdirs();
        }
        //解析requet对象，获取上传文件项
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        //解析request
        List<FileItem> fileItems = upload.parseRequest(request);
        //遍历
        for (FileItem item:fileItems){
            //进行判断  当前item对象是否为上传文件
           if(item.isFormField()) {
               //普通表单项
           }else{
               //文件项
               String name = item.getName();
               //那文件名设置为唯一值，uuid
               String uuname= UUID.randomUUID()+name;
               //完成文件上传
               item.write(new File(path,uuname));
               item.delete();
           }
        }
        return "success";
    }



    /**
     * SpringMVC方式文件上传
     */
    @RequestMapping("/fileload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("文件上传...");
        //使用fileupload组件完成文件上传
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        //判断该路径是否存在
        File file=new File(path);
        if(!file.exists()){
            //创建文件夹
            file.mkdirs();
        }
       //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        String uuname= UUID.randomUUID()+filename;
        //完成文件上传
       upload.transferTo(new File(file,uuname));
        return "success";
    }



    /**
     * 跨服务器文件上传
     */
    @RequestMapping("/fileload3")
    public String fileupload3( MultipartFile upload) throws IOException {
        System.out.println("跨服务器文件上传...");
        //定义文件上传路径
        String path ="http://loalhost:9090/uploads/";
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        String uuname= UUID.randomUUID()+filename;
        //创建客户端对象
        Client client = Client.create();
        //和图片服务器连接
        WebResource webResource = client.resource(path + "/" + uuname);
        //上传文件
        webResource.put(upload.getBytes());
        return "success";
    }


    /**
     * 异常处理
     */
    @RequestMapping("testException")
    public String testException() throws Exception {

        try {
            int a=1/0;
        } catch (Exception e) {
            e.printStackTrace();
            //抛出自定义异常
            throw new sysException("查询所有用户出现错误");
        }
        return "success";
    }


}
