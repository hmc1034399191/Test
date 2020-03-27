package com.hmc.springbootbill.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController //等价于@RequestMapping  @ResponseBody
public class ProviderTestController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("hellosql")
    public Map list(){
        String sql="select * from `user`";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        Map<String,Object>map=maps.get(0);
        return map;
    }

}
