package com.privatal.springbootweb.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @program: spring-boot-web
 * @description: TODO 自定义国际化解析器
 *      在首页选择好语言后将配置存入session以在后续的页面中引用国际化操作
 * @author: 1260535819@qq.com
 * @create: 2020-04-29 12:27
 */
public class MyLocalResolver implements LocaleResolver {
    Logger log = LoggerFactory.getLogger(getClass());
    /**
     * TODO 
     * @author : 1260535819@qq.com
     * @date : 9/5/2020 上午9:09
 * @param httpServletRequest :
     * @return : java.util.Locale
     */
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String language = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(language)){
            String[] strings = language.split("_");
            locale= new Locale(strings[0],strings[1]);
            httpServletRequest.getSession().setAttribute("locale",locale);
        }
        Object localeSession = httpServletRequest.getSession().getAttribute("locale");
        if (localeSession != null)
            locale= (Locale) localeSession;
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
