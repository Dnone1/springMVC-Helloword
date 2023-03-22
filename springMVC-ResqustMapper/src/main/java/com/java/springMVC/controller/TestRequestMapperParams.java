package com.java.springMVC.controller;

import com.java.springMVC.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/*
获取参数的方式:
1.通过servletAPI获取
只需要在控制器方法的形参位置设置HttpServletRequest类型形参
就可以在控制器通过getParameter获取请求参数

2.通过控制起形参获取
只需要在控制器形参位置，设置一个形参，形参类型和请求参数名字一致

3.@RequestParam将请求参数和控制器参数绑定
value：绑定形参的名字
required：设置是否为必须要传递的参数
默认值为true，表示value所对相应的请求参数必须传输，否在页面抛出异常->
400--Required String parameter 'username' is not present
若设置为false，则表示value所对应的请求参数不是必须传输
defaultValue：设置当没有传输对象value所对想的请求参数时，为形参设置默认值，与required属性无关

4.@RequestHeander:将请求头信息和控制器参数绑定

5.@CookieValue:将cookie信息和控制器参数绑定
 */


@Controller
public class TestRequestMapperParams {
    @RequestMapping(
            value = "/param/servlet",
            method = {RequestMethod.POST , RequestMethod.GET}
    )
    public String getParamsOne(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: "+username+"password: "+password);
        return "demo2" ;
    }

    @RequestMapping("/param")
    public String getParamsTwo(
            @RequestParam(value = "userName" , required = true , defaultValue = "hello") String username ,
            String password,
            @RequestHeader("referer") String header ,
            @CookieValue("JSESSIONID") String cook
    ) {
        System.out.println("username: "+username+"password: "+password);
        System.out.println("header: "+header);
        System.out.println("cook: "+cook);
        return "demo2" ;
    }

    @RequestMapping("/param/user")
    public String getParamByUser(User user) {
        System.out.println(user);
        return "demo2";
    }
}
