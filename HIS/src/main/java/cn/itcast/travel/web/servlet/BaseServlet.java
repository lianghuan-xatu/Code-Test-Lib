package cn.itcast.travel.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.regexp.internal.RE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //完成方法的分发
            //获取请求路径
        String uri = req.getRequestURI();   //user/add
        System.out.println("请求uri:"+uri);
        //获取方法对象
        String methodname = uri.substring(uri.lastIndexOf('/') + 1);
        System.out.println("方法名称："+methodname);
        try {
            //获取方法对象
        Method method = this.getClass().getMethod(methodname, HttpServletRequest.class, HttpServletResponse.class);

            method.invoke(this,req,resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        //执行方法
    }

    /**
     * 直接将传入对象序列化为json  回写到客户端
     * @param obj
     * @param response
     * @throws IOException
     */
    public void writeValue(Object obj,HttpServletResponse response) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),obj);
    }

    /**
     * 对象序列化为json  返回
     * @param obj
     * @return
     * @throws JsonProcessingException
     */
    public String writeValueAsString(Object obj) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(obj);
        return json;
    }
}
