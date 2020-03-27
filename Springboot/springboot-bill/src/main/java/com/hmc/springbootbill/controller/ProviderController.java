package com.hmc.springbootbill.controller;

import com.hmc.springbootbill.dao.ProviderDao;
import com.hmc.springbootbill.entities.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;

@Controller
public class ProviderController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ProviderDao providerDao;




    //用户登录
    @PostMapping("/login")//将参数与前台参数解耦
    public String IsLogin(HttpSession session,
                          @RequestParam("username")String username,
                          @RequestParam("password")String pwd,
                          Map<String,Object>map){
        //判断用户密码是否为123，
        if(!StringUtils.isEmpty(username)&&"123".equals(pwd)){
            //将用户放入Session中
            session.setAttribute("loginUser",username);
            //重定向
            return "redirect:/main.html";
        }
        map.put("msg","密码错误");
        return "main/login";
    }

    //用户退出
    @GetMapping("/logout")
    public String LoginfOut(HttpSession session){
        //将Session清空
        session.removeAttribute("loginUser");
        //将Session注销
        session.invalidate();
        return "redirect:/index.html";
    }

    //通过名称查询供应商
    @GetMapping("provider")
    public String list(Map<String,Object> map,@RequestParam(value = "providerName",required = false)String providerName){
        logger.info("查询供应商。。。。。"+providerName);
        //通过名称将供应商查询出来
        Collection<Provider> providers = providerDao.getAll(providerName);
        //放入map集合传值个前端
        map.put("providers",providers);
        //将搜索框的输入值回显到前端页面
        map.put("providerName",providerName);
        return "provider/list";
    }

    /***
     *
     * @param pid
     * @param map
     * @return
     */

    //通过ID查询供应商详细信息
    @GetMapping("/provider/{pid}")
    public String view(@PathVariable("pid")Integer pid,//通过占位符获取url里面的参数
                       @RequestParam(value = "type",defaultValue = "view")String type,
                       Map<String,Object>map){
        logger.info("供应商"+pid+"的详细信息......");
        //通过ID将一个供应商的详细信息查询出来
        Provider provider = providerDao.getProvider(pid);
        //将provder对象放在map里传值给前台
        map.put("provider",provider);
        return "provider/"+type;
    }



    //修改供应商信息
    @PutMapping("/providers")
    public String update(Provider provider){
        logger.info("修改供应商信息"+provider.getPid());
        providerDao.save(provider);
        return "redirect:/provider";
    }

    //进入增加供应商页面
    @GetMapping("/providers")
    public String toaddpage(){
        return "provider/add";
    }

    //增加供应商信息
    @PostMapping("/providersadd")
    public String providersadd(Provider provider){
        logger.info("增加供应商信息"+provider.getPid());
        providerDao.save(provider);
        return "redirect:/provider";
    }

    //删除供应商
    @DeleteMapping("/provider/{pid}")
    public String delete(@PathVariable("pid")Integer pid){
        logger.info("删除供应商....pid:"+pid);
        providerDao.delete(pid);
        return "redirect:/provider";
    }
}
