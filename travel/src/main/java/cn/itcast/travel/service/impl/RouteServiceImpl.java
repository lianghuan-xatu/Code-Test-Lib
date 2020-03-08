package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.dao.impl.*;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService
{
    private RouteDao dao=new RouteDaoImpl();
    RouteImgDao routeImgDao=new RouteImgDaoImpl();
    SellerDao sellerDao=new SellerDaoImpl();
    FavoriteDao favoriteDao=new FavoriteDaoImpl();
    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize,String rname) {
        //封装pageBean
        PageBean<Route> pageBean=new PageBean<>();
        //设置当前页码
        pageBean.setCurrentPage(currentPage);
        //设置当前每页显示条数
        pageBean.setPageSize(pageSize);
        //设置总记录数
        int totalCount=dao.findTotalCount(cid,rname);
        pageBean.setTotalCount(totalCount);
        //设置当前数据的集合
        int start=(currentPage-1)*pageSize;//开始的记录数
        List<Route> list=dao.findByPage(cid,start,pageSize,rname);
        pageBean.setList(list);
        //设置总页数
        int totalPage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize)+1;
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }

    @Override
    public Route findOne(String rid) {
            //根据id去route表中查询route对象
        Route route = dao.findOne(Integer.parseInt(rid));
            //根据route的id查询图片信息集合
        List<RouteImg> routeImgList = routeImgDao.findByRid(Integer.parseInt(rid));
        //将集合设置到对象中
        route.setRouteImgList(routeImgList);
        //根据sid（商家id）查询商家对象
        Seller seller = sellerDao.findBySid(route.getSid());
        route.setSeller(seller);
        //查询线路的收藏次数
        int count=favoriteDao.findCountByRid(route.getRid());
        route.setCount(count);

        return route;
    }
}
