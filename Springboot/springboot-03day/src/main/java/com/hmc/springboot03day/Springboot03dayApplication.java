package com.hmc.springboot03day;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


//@ImportResource(locations = {"classpath:spring01.xml"})
@SpringBootApplication
public class Springboot03dayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03dayApplication.class, args);
    }

}
