package com.hmc.springbootbill.controller;


import com.hmc.springbootbill.dao.UserDao;
import com.hmc.springbootbill.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class UserController {


    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserDao userDao;



    //如果用户名为空则查询所有用户信息，否则按照用户名查询用户信息
    @GetMapping("/user")
    public String toUser(Map<String,Object>map,@RequestParam(value = "username",required = false) String username){
        logger.info("查询用户信息-------------");
        Collection<User> users = userDao.getAll(username);
        map.put("users",users);
        map.put("username",username);
        return "user/list";
    }


    //实现两个功能整合
    //1.进入到查询页面，通过ID查询用户信息
    //2.进入到修改页面
    @GetMapping("/user/{id}")
    public String ByUserId(@PathVariable("id")Integer id,//通过占位符获取url里面的参数
                           @RequestParam(value = "type",defaultValue = "view")String type,
                           Map<String,Object>map){
        logger.info("查询ID:"+id+"的用户信息----------");
        User user = userDao.get(id);
        map.put("user",user);
        return "user/"+type;
    }


    //修改用户信息
    @PutMapping("/users")
    public String update(User user){
        logger.info("修改ID为"+user.getId()+"的用户信息---------------");
        userDao.save(user);
        return "redirect:/user";
    }

    //删除用户信息
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id")Integer id){
        logger.info("删除ID为："+id+"的用户信息------------");
        userDao.delete(id);
        return "redirect:/user";
    }


    //进入增加供应商页面
    @GetMapping("/toaddpage")
    public String toaddpage(){
        return "user/add";
    }

    //增加用户信息
    @PostMapping("/adduser")
    public String adduser(User user){
        userDao.save(user);
        return "redirect:/user";
    }
}
