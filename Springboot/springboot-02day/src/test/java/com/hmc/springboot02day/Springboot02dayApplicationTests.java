package com.hmc.springboot02day;

import com.hmc.springboot02day.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02dayApplicationTests {
    @Autowired
    private User user;

    @Test
    void contextLoads() {

        System.out.println(user);

    }

}
