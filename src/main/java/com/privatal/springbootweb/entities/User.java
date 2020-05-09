package com.privatal.springbootweb.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TODO User
 *
 * @program: spring-boot-web
 * @author: 1260535819@qq.com
 * @create: 2020-05-09 22:35
 */
@Entity
@Table(name = "tbl_user")
//必要，否则会报错，转换json字符串时忽略数组中的属性
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "last_name",length = 50)
    private String lastName;

    @Column
    private String email;
}
