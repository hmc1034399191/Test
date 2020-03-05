package com.hmc.springboot05day.myInterceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    //拦击请求之前实行下面方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从LoginController中获取Session值
        Object msg = request.getSession().getAttribute("msg");
        if(msg!=null){
            //判断已经登录，放行请求
            return true;
        }
        request.setAttribute("msg","没有权限，请先登录！");
        //转发请求
        request.getRequestDispatcher("index.html").forward(request,response);
        return false;
    }
}
