package com.situ.interceptor;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.situ.bean.RespBean;
import com.situ.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        ////获取session
        HttpSession session = request.getSession();
        ////获取登录用户信息
        User admin = (User) session.getAttribute("admin");
        //
        if (admin != null) {
            return true;
        }
        String header = request.getHeader("X-Requested-With");
        if (header != null && header.equals("XMLHttpRequest")) {
            ObjectMapper mapper = new ObjectMapper();
            RespBean respBean = RespBean.error("请重新登录");
            mapper.writeValue(response.getOutputStream(), respBean);
        } else {
            //重定向到登录页
            response.sendRedirect(request.getContextPath() + "/");
        }
        return false;
    }

}
