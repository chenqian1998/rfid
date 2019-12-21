package nju.se.rfid.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class mvcConifg implements WebMvcConfigurer {
    //扩展实现springmvc功能
    @Override
    public  void addViewControllers(ViewControllerRegistry registry) {
         registry.addViewController("/").setViewName("login");
         registry.addViewController("/success.html").setViewName("main");
    }
}
