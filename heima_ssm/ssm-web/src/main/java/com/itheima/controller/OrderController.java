package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Order;
import com.itheima.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;
  /*  //查询全部订单  不分页
    @RequestMapping("/findAll")
    private ModelAndView findAll(){
        List<Order> orders = orderService.findAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("ordersList",orders);
        mv.setViewName("orders-list");
        return mv;
    }*/
    //使用pageHelper分页查询
    @RequestMapping("/findAll")
    private ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "4")int size){
        List<Order> orders = orderService.findAll(page,size);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo=new PageInfo(orders);
        ModelAndView mv=new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }
}
