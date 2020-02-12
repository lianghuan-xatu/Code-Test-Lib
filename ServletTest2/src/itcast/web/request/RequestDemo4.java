
package itcast.web.request;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/requestDemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置流的编码
        req.setCharacterEncoding("utf-8");
        super.doPost(req, resp);
        //获取请求消息---请求参数
        //1、获取字符流
        BufferedReader br=req.getReader();
        //2、读取数据
        String line=null;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }


    }
}
