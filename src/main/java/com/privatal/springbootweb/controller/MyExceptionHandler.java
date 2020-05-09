package com.privatal.springbootweb.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: spring-boot-web
 * @description: TODO 自定义异常处理
 * @author: 1260535819@qq.com
 * @create: 2020-04-30 20:24
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        //修改错误码
        request.setAttribute("javax.servlet.error.status_code",400);
        map.put("CODE","myExceptionCode");
        map.put("MSG",e.getMessage());
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
