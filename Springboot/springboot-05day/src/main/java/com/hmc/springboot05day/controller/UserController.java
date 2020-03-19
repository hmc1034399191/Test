package com.hmc.springboot05day.controller;

import com.hmc.springboot05day.dao.UserDao;
import com.hmc.springboot05day.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserDao userDao;
    Logger logger = LoggerFactory.getLogger(getClass());

    //将查询所有用户信息和查询用户共用一个方法
    @RequestMapping("/useres")
    public String list(Map<String,Object> map,
                       @RequestParam(value = "realName",required = false)String realName){
        logger.info("查询所有用户信息");
        Collection<User> all = userDao.getAll(realName);
        map.put("realName",realName);
        map.put("user",all);
        return "user/list";
    }

    //将查询单个用户信息和进入修改页面共用一个方法
    @GetMapping("/user/{id}")
    public String view(@PathVariable("id")Integer id,Map<String,Object>map,
                       @RequestParam(value = "type",defaultValue = "view")String type){
        logger.info("查询"+id+"的用户信息");
        User user = userDao.get(id);
        map.put("user",user);
        return "user/"+type;
    }

    //进入到添加页面
    @GetMapping("/toadds")
    public String toadds(){
        return "user/add";
    }

    //添加用户信息
    @RequestMapping("user")
    public String adduser(User user){
        logger.info("添加"+user.getId()+"用户信息");
        userDao.save(user);
        return "redirect:/useres";
    }


    //修改用户信息
    @PutMapping("/user")
    public String update(User user){
        logger.info("修改"+user.getId()+"用户信息"+user);
        userDao.save(user);
        return "redirect:/useres";
    }

    //删除用户信息
    @DeleteMapping("/user/{id}")
    public String deleteuser(@PathVariable("id")Integer id){
        logger.info("删除"+id+"用户信息");
        userDao.delete(id);
        return "redirect:/useres";
    }
}
