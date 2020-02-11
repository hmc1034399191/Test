package com.hmc.springboot.controller;

import com.hmc.springboot.bean.Forte;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String init(){
        return "hello word~";
    }


}
