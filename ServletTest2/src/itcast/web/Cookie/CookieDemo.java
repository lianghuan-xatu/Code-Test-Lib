package itcast.web.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CookieDemo1")
public class CookieDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Cookie的快速入门*/
        //创建Cookie对象
        Cookie c=new Cookie("msg","hello");
        Cookie c1=new Cookie("name","zhangsan");
        //设置Cookie c1的存活时间
        /*c1.setMaxAge(30); */ //将cookie持久化到硬盘，30秒后会自动删除cookie文件

      /*  c1.setMaxAge(30000);///持久化
       */ c1.setMaxAge(0);  //删除
        /*c1.setMaxAge(-1);//关闭浏览器后删除cookie*/
        c1.setPath("/Test");//代表只有在虚拟目录/Test下的项目才可以获取cookie

        //发送Cookie
        response.addCookie(c);
        response.addCookie(c1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
