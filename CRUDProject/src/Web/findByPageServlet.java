package Web;

import Domain.PageBean;
import Domain.User;
import Service.Impl.UserServiceImpl;
import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findByPageServlet")
public class findByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数
        //避免主页点击查询未传递参数而发生异常
        if(currentPage==null||"".equals(currentPage))
        {
            currentPage="1";
        }
        if(rows==null||"".equals(rows)){
            rows="5";
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        //调用service查询
        UserService userService=new UserServiceImpl();
        PageBean<User> pb = userService.findByPage(currentPage, rows ,parameterMap);
        System.out.println(pb);
        //将pageBean存入reques
        request.setAttribute("pb",pb);
        request.setAttribute("map",parameterMap);
        //转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
