package com.hmc.springboot;

import com.hmc.springboot.bean.Forte;
import com.hmc.springboot.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot01dayApplicationTests {


    @Autowired
    User user;


    @Test
    void contextLoads() {

        System.out.println(user.toString());

    }

}
