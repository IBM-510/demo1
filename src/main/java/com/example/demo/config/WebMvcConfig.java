package com.example.demo.config;


import com.example.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor interceptor=new LoginInterceptor();
        List<String> exclude=new ArrayList<>();
        exclude.add("/js/**");
        exclude.add("/page/**");
        exclude.add("/index.html");
        exclude.add("/script.js");
        exclude.add("/style.css");
        exclude.add("/login");
        exclude.add("/regist");
        exclude.add("/login.jsp");
        exclude.add("/chat");
        exclude.add("/chat?username=*");
        exclude.add("/main.jsp");
        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(exclude);
    }

    @Configuration
    public class MyConfig implements WebMvcConfigurer {
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            //扫描static下的所有html页面
            registry.addResourceHandler("classpath:/static/*.html");
            //扫描static下的所有资源
            registry.addResourceHandler("/static/**");
        }
    }
}

