package com.hmc.springboot05day.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
//自定义区域信息解析器，国际化信息处理
public class MyLocaleResolver implements LocaleResolver {
    //请求计数
    Integer count=0;
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {

        count++;
        System.out.println("第"+count+"次请求区域信息------------");
        //从前台page获取参数l
        String l=httpServletRequest.getParameter("l");
        //获得本地默认区域信息
        Locale locale=httpServletRequest.getLocale();
        //如果参数不为空
        if(!StringUtils.isEmpty(l)){
            //将字符串分割成语言和国家/地区两个字符串
            String[] s=l.split("_");
            //通过Locale构造方法传入值
            locale=new Locale(s[0],s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
