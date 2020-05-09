package com.privatal.springbootweb.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @program: spring-boot-web
 * @description: TODO 自定义报错信息
 *        添加自定义报错信息
 *        页面保持自适应
 * @author: 1260535819@qq.com
 * @create: 2020-04-30 20:12
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("diy","doItYourself");
        @SuppressWarnings("unchecked") Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext",0);
        errorAttributes.put("ext",ext);
        return errorAttributes;
    }
}
