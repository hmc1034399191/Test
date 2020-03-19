package com.hmc.springbootbill.config;


import com.hmc.springbootbill.compoment.MyLocaleResolver;
import com.hmc.springbootbill.interceptor.LogingHandlerInterceptro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DefaultConfigtian {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("main/login");
                registry.addViewController("/index.html").setViewName("main/login");
                registry.addViewController("/main.html").setViewName("main/index");

            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LogingHandlerInterceptro())
                        //拦截所有请求
                        .addPathPatterns("/**")
                        //放行的请求
                        .excludePathPatterns("/","/index.html","/login")
                        //spring2.0会默认拦截静态资源，所有要放行
                        .excludePathPatterns("/static/**");

            }
        };
    }

    //需要替换mvc自动配置类中区域解析器,
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


}
