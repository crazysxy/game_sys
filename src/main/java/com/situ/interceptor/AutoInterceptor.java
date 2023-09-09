package com.situ.interceptor;

import com.situ.bean.User;
import com.situ.service.UserService;
import com.situ.service.impl.UserServiceImpl;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;

public class AutoInterceptor implements HandlerInterceptor {
    //@Autowired
    private UserService userService= new UserServiceImpl();
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("aotoInterceptor");

        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            String value=null;
            //遍历全部的Cookie
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("auto")){
                    value=cookie.getValue();
                }
            }
            if(value!=null){
                value= URLDecoder.decode( value,"utf-8" );

                //获取Cookie中的username password
                String[] split = value.split("=");

                String username=split[0];
                String password=split[1];

                System.out.println(username);
                System.out.println(password);

                User user = userService.findUserByUsernameAndPassword(username, password);
                System.out.println(user.toString());
                System.out.println("user:"+user);
                if(user!=null){
                    HttpSession session = request.getSession();
                    session.setAttribute("admin", user);
                    response.sendRedirect( "/admin/index" );
                }
            }
            else {
                return true;
            }

        }
        else {
            return true;

        }
        return true;
    }

}
