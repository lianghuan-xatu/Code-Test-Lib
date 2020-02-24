package Web.Filter;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class loginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强制转换
        HttpServletRequest request=(HttpServletRequest) req;
        //获取资源请求路径
        String requestURI = request.getRequestURI();
        //判断是否为登录相关的资源路径
        if(requestURI.contains("/login.jsp")||requestURI.contains("/loginServlet")||requestURI.contains("/checkCodeServlet")||requestURI.contains("/css/")||requestURI.contains("/js/")||requestURI.contains("/fonts/"))
        {       //包含用户想登录，放行
            chain.doFilter(req,resp);
        }else{
            //判断用户是否已经登录
            //获取Session
            HttpSession session = request.getSession();
            Object user = session.getAttribute("user");
            if(user!=null){
                //包含登录信息，直接放行
                chain.doFilter(req,resp);
            }else{
                //没有登录信息 跳转登录
                request.setAttribute("login_msg","请登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }

    }

    public void destroy() {

    }


}
