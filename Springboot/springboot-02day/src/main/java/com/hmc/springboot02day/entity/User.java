package com.hmc.springboot02day.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@PropertySource(value = {"classpath:user.properties"})
@Component
@ConfigurationProperties(prefix = "user")
public class User {

    @Value(value = "${user.names}")
    private String names;
    @Value(value = "${user.age}")
    private Integer age;
    @Value(value = "4500")
    private Double Yue;
    private Map map;
    private List list;
    private Emp emp;


    @Override
    public String toString() {
        return "User{" +
                "names='" + names + '\'' +
                ", age=" + age +
                ", Yue=" + Yue +
                ", map=" + map +
                ", list=" + list +
                ", emp=" + emp +
                '}';
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getYue() {
        return Yue;
    }

    public void setYue(Double yue) {
        Yue = yue;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }
}
