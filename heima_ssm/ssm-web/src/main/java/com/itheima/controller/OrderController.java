package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.DateStringEditor;
import com.itheima.domain.Order;
import com.itheima.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    //自定义类型转换器
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new DateStringEditor());
    }

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


    /***
     *订单详情
     * @param orderId
     * @return
     */
    @RequestMapping("/findById")
    private ModelAndView findById(@RequestParam(name = "id",required = true)String orderId){
        ModelAndView mv=new ModelAndView();
        Order order = orderService.findById(orderId);
        mv.addObject("orders",order);
        mv.setViewName("order-show");
        return mv;
    }
}
