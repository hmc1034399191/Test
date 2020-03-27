package com.hmc.springbootjdbc.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
    public class DruidConfiguration {

        //在DataSourceProperties里面也是用的这个前缀
        @ConfigurationProperties( prefix = "spring.datasource")
        @Bean
        public DataSource Druid(){
            return new DruidDataSource();
        }


        //1.配置一个Druid后台管理Servlet
    public ServletRegistrationBean staviewServlet(){
            return new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
    }

}
