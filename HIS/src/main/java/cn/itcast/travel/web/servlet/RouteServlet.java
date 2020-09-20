package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
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
    private FavoriteService favoriteService=new FavoriteServiceImpl();
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");
        String rname = request.getParameter("rname");
        rname=new String(rname.getBytes("iso-8859-1"),"utf-8");

        int cid=0;
        //处理参数
        if(cidStr!=null&&cidStr.length()>0&&!cidStr.equals("null")){
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
        if(rname.equals("null")){
            rname="";
        }
        //调用service查询pageBean对象
        PageBean<Route> pageBean = routeService.pageQuery(cid, currentPage, pageSize,rname);
        System.out.println(pageBean);
        System.out.println(Arrays.toString(pageBean.getList().toArray()));
        //将pb对象序列化到json
        writeValue(pageBean,response);

    }

    /**
     * 根据id查询一个旅游线路的详细信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //接受id
        String rid = request.getParameter("rid");
        //调用service查询route对象
        Route route = routeService.findOne(rid);
        //回写到客户端
        writeValue(route,response);

    }

    /**
     * 判断当前登录用户是否收藏过该线路
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //获取线路id
        String rid=request.getParameter("rid");
        //获取当前登录的用户 user
        User user = (User) request.getSession().getAttribute("user");
        int uid;//用户id
        if(user==null){
            //用户尚未登陆
            uid=0;
        }else{
            //用户已经登陆
            uid=user.getUid();
        }
        //调用FavoriteServic查询是否收藏过
        boolean flag = favoriteService.isFavorite(rid, uid);
    //写回客户端
        writeValue(flag,response);

    }
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取线路id
        String rid = request.getParameter("rid");
        //获取当前登录的用户 user
        User user = (User) request.getSession().getAttribute("user");
        int uid;//用户id
        if (user == null) {
            //用户尚未登陆
           return;
        } else {
            //用户已经登陆
            uid = user.getUid();
        }
        //调用service添加
        favoriteService.add(rid,uid);

    }

    }
