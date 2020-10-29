package com.usian.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usian.pojo.Student;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler)throws Exception {
        Student user = (Student) request.getSession().getAttribute("user");
        if(user!=null){
            return true;
        }
        String uri = request.getRequestURI();
        if (uri.contains("login")){
            return  true;
        }
        if (uri.contains("zhuce")){
            return  true;
        }
        response.sendRedirect("/tologin");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler,ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex)throws Exception {
    }

}