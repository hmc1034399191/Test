package com.hmc.springboot05day.config;

import com.hmc.springboot05day.component.MyLocaleResolver;
import com.hmc.springboot05day.myInterceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfigtion {


    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer(){
            //视图解析器控制视图
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("main/login");
                registry.addViewController("/index.html").setViewName("main/login");
                registry.addViewController("/main.html").setViewName("main/index");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor())
                        //拦截所有请求
                        .addPathPatterns("/**")
                        //放行请求
                        .excludePathPatterns("/","/index.html","/login")
                        //放行静态资源
                        .excludePathPatterns("/css/**","/img/**","/js/**");
            }
        };
    }

    //需要替换mvc自动配置类中区域解析器,
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
