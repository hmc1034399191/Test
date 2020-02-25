package com.hmc.springboot03day;

import com.hmc.springboot03day.service.EmpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;


@SpringBootTest
class Springboot03dayApplicationTests {


    @Autowired
    ApplicationContext context;

    //测试使用xml文件创建对象
    @Test
    void contextLoads() {
        EmpService empservers =(EmpService) context.getBean("empservers");
        System.out.println("EmpService1:"+empservers);
    }

    //自定义配置类创建对象
    @Test
    void applicationTest(){
        EmpService empservers =(EmpService) context.getBean("empService2");
        System.out.println("EmpService1:"+empservers);
    }

}
