package com.hmc.springboot05day.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam("username") String name,
                        @RequestParam("password") String pwd,
                        Map<String,Object>map,
                        HttpSession session){

        if("何明聪".equals(name)){
            if ("123".equals(pwd)){
                    session.setAttribute("msg",name);
                    return "redirect:/main.html";
                }else {
                    map.put("msg","密码不正确！");
                    return "main/login";
                }
        }else{
            map.put("msg","用户名不正确！");
            return "main/login";
        }
//        if(StringUtils.isEmpty(name)||StringUtils.isEmpty(pwd)){
//            map.put("msg","账号或密码不能为空！");
//            return "main/login";
//        }else{
//            if("何明聪".equals(name)){
//                if ("123".equals(pwd)){
//                    return "redirect:/main.html";
//                }else {
//                    map.put("msg","密码不正确！");
//                    return "main/login";
//                }
//            }else{
//                map.put("msg","用户名不正确！");
//                return "main/login";
//            }
//        }
    }
}
