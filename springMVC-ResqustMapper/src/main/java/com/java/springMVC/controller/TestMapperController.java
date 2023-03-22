package com.java.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
1.@RequestMapper标识的位置
    @RequestMapping标识一个类：设置映射请求的请求路径的初始信息
    @RequestMapping标识一个方法：设置映射请求请求路径的具体信息
    注意:当@RequestMapper标识到一个类中和当前类中的方法上就需要先访问初始信息在访问具体信息

2.@RequestMapp注解value属性
    作用:通过请求的请求路径匹配value{}中的值
    value属性是数组类型，即当前浏览器发送请求匹配value属性的任意一个值
    则当前的请求就会被注解所标识的方法就会处理

3.@RequestMapper注解的method属性
    作用:通过请求的请求方式匹配请求
    method是@RequestMapper中的数组属性,即当前浏览器发送请求匹配method属性的任意一个值
    则当前的请求就会被注解所标识的方法就会处理
    若浏览器所发送的请求路径和@RequestMapper中的value属性匹配但是method属性不匹配
    此时页面会显示报错 --405
    在@RequestMapper的基础上，结合请求方式的一些派生注解：
    @GetMapper,@PostMapper,@DeleteMapper,@PutMapper

4.@RequestMapper注解的Params属性
    作用：通过请求的请求参数匹配请求，即浏览器发送的请求必须满足params的参数设置
    params四种表达式：
    "param": 表示当前所匹配的请求参数必须携带param
    "!param": 表示当前所匹配的请求参数不能携带param
    "param = value": 表示当前所匹配的请求参数必须携带param值=value
    "param != value": 表示当前所匹配的请求参数必须携带param值不=value
     异常：--400

    注意：params虽然是数组，但是params不是匹配任意一个值，而是全部匹配

5.@RequestMapper注解的headers
    @RequestMapping注解的headers属性通过请求的请求头信息匹配请求映射
    @RequestMapping注解的headers属性是一个字符串类型的数组，可以通过四种表达式设置请求头信
    息和请求映射的匹配关系
    "header"：要求请求映射所匹配的请求必须携带header请求头信息
    "!header"：要求请求映射所匹配的请求必须不能携带header请求头信息
    "header=value"：要求请求映射所匹配的请求必须携带header请求头信息且header=value
    "header!=value"：要求请求映射所匹配的请求必须携带header请求头信息且header!=value
    若当前请求满足@RequestMapping注解的value和method属性，但是不满足headers属性，此时页面
    显示404错误，即资源未找到

6.springMVC支持的ant风格的路径
    ?:路径中的任意的单个字符（不包括？和/）
    *:路径中的0-任意字符
    **:路径中的任意层次的任意目录,使用的方式只能是\**\,前后不能有人字符

7.SpringMVC支持路径中的占位符
    原始方式：/deleteUser?id=1
    rest方式：/user/delete/1/username

    在相应的@RequestMapping注解的value属性中通过占位符{xxx}表示传输的数据
    通过@PathVariable注解，将占位符所表示的数据赋值给控制器方法的形参
 */

@Controller
//@RequestMapping("/user")
public class TestMapperController {

    @RequestMapping(
            value = {"/success" , "/demo"},
            method = {RequestMethod.GET , RequestMethod.POST}
//            params = {"param" , "!age" , "name=杨"}
//            headers = {}

            )
    public String success() {
        return "demo";
    }

    @RequestMapping
    (
//            value = {"/a?a/ant"}第一种方式
//            value = {"/*/ant"}第二种方式
            value = {"/**/ant"}
    )
    public String demo2() {
        return "demo2" ;
    }

    @RequestMapping(value = {"/text/rest/{id}/{username}"})
    public String textRest(@PathVariable("id") Integer id , @PathVariable("username")String username) {
        System.out.println("id: "+id+",username: "+username);
        return "demo2" ;
    }


}
