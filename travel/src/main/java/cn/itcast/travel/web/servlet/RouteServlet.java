package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;


public class RouteServlet extends BaseServlet {
    private RouteService routeService=new RouteServiceImpl();
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");
        
        int cid=0;
        //处理参数
        if(cidStr!=null&&cidStr.length()>0){
            cid=Integer.parseInt(cidStr);
        }
        int currentPage=0; //如果不传递参数默认第一页
        if(currentPageStr!=null&&currentPageStr.length()>0){
            currentPage=Integer.parseInt(currentPageStr);
        }else{
            currentPage=1;
        }
        int pageSize=0;//每页显示条数，如果不传递，默认显示5条记录
        if(pageSizeStr!=null&&pageSizeStr.length()>0){
            pageSize=Integer.parseInt(pageSizeStr);
        }else{
            pageSize=5;
        }
        //调用service查询pageBean对象
        PageBean<Route> pageBean = routeService.pageQuery(cid, currentPage, pageSize);
        System.out.println(pageBean);
        System.out.println(Arrays.toString(pageBean.getList().toArray()));
        //将pb对象序列化到json
        writeValue(pageBean,response);

    }

  
}
