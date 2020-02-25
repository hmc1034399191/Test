package com.hmc.springboot03day.configtion;


import com.hmc.springboot03day.service.EmpService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmpConfigtion {


    @Bean
    public EmpService empService2(){
        System.out.println("自定义配置类创建对象");
        return new EmpService();
    }
}
