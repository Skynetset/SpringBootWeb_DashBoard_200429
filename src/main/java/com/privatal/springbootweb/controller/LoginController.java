package com.privatal.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @program: spring-boot-web
 * @description: TODO LoginController
 * @author: 1260535819@qq.com
 * @create: 2020-04-29 15:22
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Map<String,Object> context, HttpSession session){
        if (!StringUtils.isEmpty(username)&&"123456".equals(password)){
            //重定向成功页，防止重复提交表单
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            context.put("MSG","用户名密码错误");
            return "login";
        }
    }
}
