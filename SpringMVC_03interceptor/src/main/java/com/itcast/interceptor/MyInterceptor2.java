package com.itcast.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MyInterceptor2 implements HandlerInterceptor
{


    /**
     *
     *
     * 配置多个拦截器执行顺序：·
     * 配置多个拦截器执行顺序：·
     *   MyInterptor前111
     *   MyInterptor前222
     *   MyInterptor后222
     *   MyInterptor后111
     *   success.jsp执行
     *   MyInterptor最后222
     *   MyInterptor最后111
     *
     *
     */
    /**
     * 预处理，controller方法执行之前
     * return true放行，执行下一个拦截器，如果没有，执行controller中的方法
     * return false不放行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("222");
        return true;
    }


    /**
     * 后处理方法，controller方法执行之后，success.jsp页面之前  
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("222MyInterptor执行后");
    }

    /**
     * 最后处理方法    success.jsp展示之后执行  
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("222最后执行方法 ");
    }
}
