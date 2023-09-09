package com.situ.config;

import com.situ.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackages = "com.situ.controller" ,useDefaultFilters = false,
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class))
public class SpringmvcConfig implements WebMvcConfigurer {
    //配置视图解析器

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".html");
        return  resolver;
    }

    //对静态资源放行
    @Override
    public  void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
        .excludePathPatterns("/admin/signup1");
        //registry.addInterceptor(new AutoInterceptor())
        //        .addPathPatterns("/");
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/admin/index").setViewName("index");
        registry.addViewController("/admin/feedback").setViewName("feedback");
        registry.addViewController("/admin/gamingcompany").setViewName("gamingcompany");
        registry.addViewController("/admin/gameinfo").setViewName("gameinfo");
        registry.addViewController("/admin/signup1").setViewName("signup1");
        registry.addViewController("/admin/updatePassword").setViewName("updatePassword");


    }
}
