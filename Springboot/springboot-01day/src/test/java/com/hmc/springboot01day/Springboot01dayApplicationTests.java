package com.hmc.springboot01day;

import com.hmc.springboot01day.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot01dayApplicationTests {

    @Autowired
    private User user;

    @Test
    void contextLoads() {
        System.out.println(user);
    }

}
