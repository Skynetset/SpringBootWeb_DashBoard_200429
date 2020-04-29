package com.privatal.springbootweb.config;

import com.privatal.springbootweb.component.LoginHandleInterceptor;
import com.privatal.springbootweb.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description:
 * 扩展SpringMVC，保留自动配置，并可以新增自定义配置
 * -@EnableWebMvc 全面接管SpringMVC
 *
 * @date: 27/4/2020
 * @time: 下午3:56
 * @author: 1260535819@qq.com
 * @file: spring-boot-web
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * @Description : TODO 字段排除
     * @Author : 1260535819@qq.com
     * @Date : 29/4/2020 下午5:30
     */
    public static String[] excludes={"/","/index.html","/user/login","/asserts/**","/static/**","/webjars/**"};

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/a123").setViewName("success");
    }

    /**
     * @Description : TODO 首页配置
     *      -@Bean将组件加入容器中
     *      自定义视图解析器
     * @Author : 1260535819@qq.com
     * @Date : 28/4/2020 下午5:11
     * @return : org.springframework.web.servlet.config.annotation.WebMvcConfigurer
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                //重定向成功页
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            //注册自定义拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandleInterceptor())
                        .addPathPatterns("/**")
                        .excludePathPatterns(excludes);
            }
        };
    }
    /**
     * @Description : TODO 注入自定义国际化配置
     * @Author : 1260535819@qq.com
     * @Date : 29/4/2020 下午3:17
     * @return : org.springframework.web.servlet.LocaleResolver
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
