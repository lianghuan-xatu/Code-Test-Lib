package Web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 敏感词汇过滤器
 */
@WebFilter("/filterTestServlet")
public class sensitiveWordsFilter implements Filter {
    //定义list集合存储加载到的敏感词汇
    List<String> list=new ArrayList<>();
    public void init(FilterConfig config) throws ServletException {
        //获取文件真实路径
        ServletContext servletContext = config.getServletContext();
        String realPath = servletContext.getRealPath("WEB-INF/classes/敏感字符.txt");
        try {
            //获取文件的真实路径
            FileInputStream fis=new FileInputStream(realPath);
            //读取文件
            InputStreamReader isr=new InputStreamReader(fis,"utf-8");
            BufferedReader br=new BufferedReader(isr);
            String line=null;
            //将文件的每一行数据添加到list
            while ((line=br.readLine())!=null){
                list.add(line);
            }
            br.close();
            System.out.println(list.toArray());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(list.toArray());
        //创建req动态代理对象，增强getParameter方法
         ServletRequest proxy_req=(ServletRequest)Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //判断是否是getParameter方法
                if(method.getName().equals("getParameter")){
                    String value = (String)method.invoke(req, args);
                    if(value!=null){
                        for(String str:list){
                            if(value.contains(str)){
                                value=value.replaceAll(str,"***");
                            }
                        }
                    }
                    return value;
                }
                //判断方法名是否是getParameterMap

                //判断方法名是否是getParameterValue




                return method.invoke(req,args);
            }
        });
        chain.doFilter(proxy_req, resp);
    }

    public void destroy() {

    }


}
