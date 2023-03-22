package com.java.springMVC.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

/*
向域对象中共享数据

1. 通过ModelAndView向请求与对象中共享数据
使用ModelAndView时，可以使用Model功能向请求域共享数据
使用View功能设置逻辑视图，但是控制器方法一定要将ModelAndView作为方法的返回值

取值：标签中使用th:text=${key值}方式取值
<p th:text="${model}"></p>

2. 使用Model向请求域中共享数据
3. 使用ModelMap向请求域中共享数据
4. 使用Map向请求域中共享数据

5.Model,ModelMap,Map关系
其实在底层这些类型的形参都是通过-org.springframework.validation.support.BindingAwareModelMap-创建的

6. 通过session向会话与请求共享数据
    浏览器关闭，session消失，除非使用钝化或者活化

7. 通过application向应用中共享数据
    服务器关闭，application消失
 */

@Controller
public class ScopeController {

    @RequestMapping("/mav/text")
    public ModelAndView success() {

        /*
        ModelAndView：
        model：向请求域中共享数据
        view：设置逻辑视图实现页面跳转
         */
        ModelAndView mac = new ModelAndView();

        //向请求域中共享数据  key--value
        mac.addObject("ModelAndView" , "通过ModelAndView向请求与对象中共享数据");

        //设置逻辑视图
        mac.setViewName("success");

        return mac ;
    }

    @RequestMapping("/madel/text")
    public String model(Model model) {
        model.addAttribute("model" , "使用Model向请求域中共享数据");
        System.out.println(model.getClass().getName());
        return "success";
    }

    @RequestMapping("/madelMap/text")
    public String modelMap(ModelMap modelMap) {
        modelMap.addAttribute("modelMap" , "使用ModelMap向请求域中共享数据");
        System.out.println(modelMap.getClass().getName());
        return "success";
    }

    @RequestMapping("/map/text")
    public String map(Map<String , Object> map) {
        map.put("map" , "使用Map向请求域中共享数据");
        System.out.println(map.getClass().getName());
        return "success";
    }

    @RequestMapping("/session/text")
    public String session(HttpSession session) {
        session.setAttribute("ses" , "通过session向会话与请求中共享数据");
        return "success";
    }

    @RequestMapping("/application/text")
    public String application(HttpSession session) {
        ServletContext context = session.getServletContext();
        context.setAttribute("app" , "通过application向应用中共享数据");
        return "success";
    }

}
