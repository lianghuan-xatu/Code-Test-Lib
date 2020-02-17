package itcast.web.Session.Servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet2")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1、创建一个对象，在内存中图片（验证码图片对象）
        int width=100;
        int height=50;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);



        // 2、美化图片
                //填充背景色
        Graphics g = image.getGraphics();//画笔对象
        g.setColor(Color.PINK);//设置画笔颜色
        g.fillRect(0,0,width,height);
        g.setColor(Color.BLUE);//画边框
        g.drawRect(0,0,width-1,height-1);
        //写验证码
        String str="ABCDEFGHIJKLMNOPKISTUVWXYZabcdefghijklmnopkistuvwxyz";
                //生成随机角标
        StringBuilder sb=new StringBuilder("");
                Random rm=new Random();
               for(int i=0;i<4;i++){

                    int index = rm.nextInt(str.length());
                    //获取字符
                    char c = str.charAt(index);//随机字符
                   sb.append(c);
                     g.drawString(c+"",width/5*i,height/2);
                }
        String s = sb.toString();
        HttpSession session = request.getSession();
        session.setAttribute("checkCode",s);

       /* g.drawString("A",20,25);
        g.drawString("B",40,25);
        g.drawString("C",60,25);
        g.drawString("d",80,25);
*/
       //画干扰线
        g.setColor(Color.GREEN);
        //随机生成坐标点
        for(int i=0;i<10;i++) {
            int x1 = rm.nextInt(width);
            int x2 = rm.nextInt(width);
            int y1 = rm.nextInt(height);
            int y2 = rm.nextInt(height);

            g.drawLine(x1, y1, x2, y2);
        }
        //3、将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
