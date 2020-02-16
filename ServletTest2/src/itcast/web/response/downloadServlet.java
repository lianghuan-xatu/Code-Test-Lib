package itcast.web.response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class downloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       /* 定义servlet
        1、获取文件名称
        2、使用字节输入流加载文件进内存
        3、指定response的响应头
        4、将数据写出到response的输出流*/
       String filename=request.getParameter("filename");
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/Img/" + filename);
        //设置reponse响应头
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-Type",mimeType);
        //解决中文文件名问题
            //获取user-agent请求头
        String agentname = request.getHeader("user-agent");
        String fileName = DownloadUtils.getFileNames(agentname, filename);//获取到符合格式的filename
        response.setHeader("content-disposition","attachment;filename="+fileName);
        FileInputStream fileInputStream = new FileInputStream(realPath);
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buff=new byte[1024*8];
        int len=0;
        while ((len=fileInputStream.read(buff))!=-1){
            outputStream.write(buff,0,len);
        }
        fileInputStream.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }
}
