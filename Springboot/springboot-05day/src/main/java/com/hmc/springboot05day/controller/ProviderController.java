package com.hmc.springboot05day.controller;


import com.hmc.springboot05day.dao.ProviderDao;
import com.hmc.springboot05day.entities.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

@Controller
public class ProviderController {
    Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    ProviderDao providerDao;
    //查询所有供应商信息
    @GetMapping("/providers")
    public String list(Map<String,Object> map,
                       @RequestParam(value = "ProviderName",required = false) String ProviderName){
        logger.info("供应商查询"+ProviderName);
        Collection<Provider> all = providerDao.getAll(ProviderName);
        map.put("providers",all);
        map.put("ProviderName",ProviderName);
        return "provider/list";
    }

    /**
     * 将按ID查询供应商详细信息,和进入修改页面公用一个方法
     * type=null,默认进入view.html
     * type=update,进入update.html
     * @param pid
     * @param type
     * @param map
     * @return
     */
    @GetMapping("/provider/{pid}")
    public String view(@PathVariable("pid")Integer pid,
                       @RequestParam(value = "type",defaultValue = "view")String type,
                       Map<String,Object>map){
        logger.info("查询ID为："+pid+"供应商的详细信息");
        Provider provider = providerDao.getProvider(pid);
        map.put("provider",provider);
        return "provider/"+type;
    }

    //修改供应商信息
    @PutMapping("/provider")
    public String update(Provider provider){
        logger.info("修改供应商信息"+provider.getPid());
        providerDao.save(provider);
        return "redirect:/providers";
    }


    //进入添加页面
    @GetMapping("/toadd")
    public String toaddpage(){
        return "provider/add";
    }

    //添加供应商信息
    @PostMapping("/provider")
    public String addprovideres(Provider provider){
        logger.info("添加供应商信息:"+provider);
        providerDao.save(provider);
        return "redirect:providers";
    }

    //删除供应商信息
    @DeleteMapping("/provider/{pid}")
    public String delete(@PathVariable("pid")Integer pid){
        logger.info("删除pid为："+pid+"的供应商信息");
        providerDao.delete(pid);
        return "redirect:/providers";
    }

}
