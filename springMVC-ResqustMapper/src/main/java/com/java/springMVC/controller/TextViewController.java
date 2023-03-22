package com.java.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.Contended;
/*
1、ThymeleafView
    当控制器方法中所返回的视图名称没有任何前缀时，此时的视图名称会被SpringMVC配置文件中所配置的视图解析器解析，
    视图名称拼接视图前缀和视图后缀所得到的最终路径，会通过转发的方式实现跳转

2、转发视图InternalResourceView
    SpringMVC中默认的转发视图是InternalResourceView
    SpringMVC中创建转发视图的情况：
    当控制器方法中所设置的视图名称以"forward:"为前缀时，创建InternalResourceView视图，此时的视
    图名称不会被SpringMVC配置文件中所配置的视图解析器解析，而是会将前缀"forward:"去掉，剩余部
    分作为最终路径通过转发的方式实现跳转
    例如"forward:/"，"forward:/employee"

3、重定向视图RedirectView
    SpringMVC中默认的重定向视图是RedirectView
    当控制器方法中所设置的视图名称以"redirect:"为前缀时，创建RedirectView视图，此时的视图名称不
    会被SpringMVC配置文件中所配置的视图解析器解析，而是会将前缀"redirect:"去掉，剩余部分作为最
    终路径通过重定向的方式实现跳转
    例如"redirect:/"，"redirect:/employee"

4, 视图控制器view-controller
    当控制器方法仅仅是用来页面跳转的时候，可以使用处理器方法<mvc:view-controller>标签进行处理

    path：设置处理的请求地址
    view-name：设置请求地址所对应的视图名称

    注意：当springMVC设置一个view-controller时，其他控制器请求映射全部404，此时需要在springMVC核心配置文件中
    开启mvc注解驱动

 */

@Controller
public class TextViewController {


    @RequestMapping("/thymeleaf/text")
    public String thymeleaf() {
        return "success" ;
    }

    @RequestMapping("/internal/text")
    public String internal () {
        return "forward:/session/text" ;
    }

    @RequestMapping("/redirect/text")
    public String redirect() {
        return "redirect:/session/text";
    }

}
