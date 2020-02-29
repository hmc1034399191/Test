package com.hmc.springboot05day.controller;

import com.hmc.springboot05day.entity.User;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {



    @RequestMapping("/hello")
    public String exectu(Map<String,Object>map){

        map.put("user","张三");
        return "one";
    }

    @RequestMapping("/test")
    public String exe(Map<String,Object>map){
        List<User> list=new ArrayList<User>();
        list.add(new User("张三",1));
        list.add(new User("李四",2));
        list.add(new User("王五",1));
        map.put("list",list);
        return "Two";
    }
}
