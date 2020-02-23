package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//浏览器直接请求资源时，该该过滤器被执行  dispatcherTypes = DispatcherType.REQUEST
//浏览器直接请求资源时，资源别转发访问该该过滤器被执行dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.FORWARD}
//index.jsp资源被请求转时，过滤器会执行
/*@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.FORWARD)*/
public class FilterDemo4 implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter被访问....");
        chain.doFilter(req, resp);
    }

    public void destroy() {

    }


}
