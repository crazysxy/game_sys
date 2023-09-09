package com.situ.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.situ.bean.RespBean;
import com.situ.bean.User;
import com.situ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody()
    public RespBean login( String autolog,String username, String password,String codeInput ,HttpSession session,HttpServletResponse response) throws UnsupportedEncodingException {
        String code = (String) session.getAttribute("code");
        if(!code.equalsIgnoreCase(codeInput)){
            return RespBean.error("验证码输入错误");
        }
        User user = userService.findUserByUsernameAndPassword(username, password);
        if(user==null){
            return RespBean.error("用户名或密码错误，请重新登录");
        }

        //判断前端是否勾选自动登录
        if(autolog!=null){
            String count = username+ "=" + password;
            count = URLEncoder.encode(count, "UTF-8");
            Cookie auto = new Cookie("auto", count);
            auto.setMaxAge(60 * 60 * 24 * 5);
            response.addCookie(auto);

        }else {
            Cookie auto = new Cookie("auto", "");
            auto.setMaxAge(0);
            response.addCookie(auto);

        }
        session.setAttribute("admin", user);
        return RespBean.ok("登录成功");
    }
    @ResponseBody
    @GetMapping("/logout")
    public RespBean logout(HttpSession session, HttpServletRequest request,HttpServletResponse response){

        Cookie[] cookies = request.getCookies();
        if(cookies!=null){

            for(Cookie cookie:cookies){
                if(cookie.getName().equals("auto")){

                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        session.invalidate();
        return RespBean.ok("退出成功");

    }
    @RequestMapping("/code")
    public void code(HttpSession session,HttpServletResponse response) throws IOException {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(120, 38, 4, 20);
        String code = lineCaptcha.getCode();
        session.setAttribute("code", code);
        lineCaptcha.write(response.getOutputStream());
    }

    @ResponseBody
    @RequestMapping("/signup")
    public RespBean signUp(String username, String password,String codeInput ,HttpSession session){
        String code = (String) session.getAttribute("code");
        if(!code.equalsIgnoreCase(codeInput)){
            return RespBean.error("验证码输入错误");
        }

        User byUsername = userService.findByUsername(username);
        if(byUsername!=null){
            return RespBean.error("该用户已存在");
        }
        userService.signUp(username, password);
        return RespBean.ok("注册成功");

    }

    @ResponseBody
    @GetMapping("/userInfo")
    public RespBean userInfo( HttpSession session){
        User admin = (User) session.getAttribute("admin");
        return RespBean.ok("查询成功", admin);

    }

    @RequestMapping("/updpsd")
    public  RespBean updatePassword(String username, String password ,HttpSession session,String newPassword) throws Exception {

        User UserbyUsername = userService.findByUsername(username);
        if(!UserbyUsername.getPassword().equals(password)){

            return RespBean.error("密码错误");
        }


        int i = userService.updatePassword(username, password, newPassword);

        return RespBean.ok("修改成功~");

    }



}
