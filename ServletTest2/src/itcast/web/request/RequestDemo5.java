
package itcast.web.request;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.util.Enumeration;
        import java.util.Map;
        import java.util.Set;

@WebServlet("/requestDemo5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置流的编码
        req.setCharacterEncoding("utf-8");
        super.doPost(req, resp);
        //post获取请求参数
        //根据参数名称获取参数值
        String username=req.getParameter("username");
        System.out.println("POST");
        System.out.println(username);
        //根据参数名获取参数值的数组
        String[] hobbies=req.getParameterValues("hobby");
        for(String hobby:hobbies){
            System.out.println(hobby);
        }
        //获取所以请求的参数名称
        Enumeration<String> parameterNames=req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = req.getParameter(name);
            System.out.println(value);
            System.out.println("======================");
        }

        //获取所有参数的Map集合
        Map<String,String[]> parameterMap=req.getParameterMap();
      //遍历
        Set<String> keyset=parameterMap.keySet();
        for (String name:keyset){
            //获取键对应的值
            String[] values=parameterMap.get(name);
            System.out.println(name);
            for (String value:values){
                System.out.println(value);
            }
            System.out.println("=========================");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    //get获取请求参数
        //根据参数名称获取参数值
     /*   String username=req.getParameter("username");
        System.out.println("GET");
        System.out.println(username);*/
     this.doPost(req,resp);
    }

}