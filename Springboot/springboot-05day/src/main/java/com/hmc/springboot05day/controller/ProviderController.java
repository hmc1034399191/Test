package com.hmc.springboot05day.controller;


import com.hmc.springboot05day.dao.ProviderDao;
import com.hmc.springboot05day.entities.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Map;

@Controller
public class ProviderController {
    Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    ProviderDao providerDao;
    //查询所有供应商信息
    @GetMapping("/providers")
    public String list(Map<String,Object> map,@RequestParam(value = "ProviderName",required = false) String ProviderName){
        logger.info("供应商查询"+ProviderName);
        Collection<Provider> all = providerDao.getAll(ProviderName);
        map.put("providers",all);
        map.put("ProviderName",ProviderName);
        return "provider/list";
    }


    //按ID查询供应商详细信息
    @GetMapping("/provider/{pid}")
    public String view(@PathVariable("pid")Integer pid,Map<String,Object>map){
        logger.info("查询ID为："+pid+"供应商的详细信息");
        Provider provider = providerDao.getProvider(pid);
        map.put("provider",provider);
        return "provider/view";
    }

}
