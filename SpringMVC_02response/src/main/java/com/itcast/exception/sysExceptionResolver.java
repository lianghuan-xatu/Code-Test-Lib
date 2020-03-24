package com.itcast.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sysExceptionResolver implements HandlerExceptionResolver
{
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取异常对象
        sysException ex=null;
        if(ex instanceof sysException){
            e=(sysException)ex;
        }else {
            e = new sysException("系统维护中....");
        }
        //创建ModelAndView对象
        ModelAndView mv=new ModelAndView();
        mv.addObject("errorMsg",e.getMessage());
        mv.setViewName("error");
        return null;
    }
}
