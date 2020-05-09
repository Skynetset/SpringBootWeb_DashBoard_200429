package com.privatal.springbootweb.entities;

import lombok.Data;

/**
 * Some personal configuration from properties
 *      -@ConfigurationProperties(prefix = "myproperties") 从全局配置文件获取属性
 *      -@PropertySource(value = "classpath:myproperties.properties") 加载指定配置文件
 * @program: spring-boot-web
 * @author: 1260535819@qq.com
 * @create: 2020-05-09 10:58
 */
//@Component
//@PropertySource(value = "classpath:myproperties.properties")
@Data
public class MyProperties {
    private String path;
}
