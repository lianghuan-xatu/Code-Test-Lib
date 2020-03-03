package Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class findUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取用户名
        String username = request.getParameter("username");
        Map<String,Object> map=new HashMap<>();
        //2、调用service层判断用户名是否存在
        if("tom".equals(username)){
            //存在
            map.put("userExsit",true);
            map.put("userMsg","此用户名太受欢迎，请更换一个");

        }else{
            map.put("userExsit",false);
            map.put("userMsg","用户名可用");
        }
        //3、将map转为json，并且传递给客户端
        //response.setContentType("text/html;charset=utf-8");
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
