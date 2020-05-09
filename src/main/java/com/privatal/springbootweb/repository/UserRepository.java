package com.privatal.springbootweb.repository;

import com.privatal.springbootweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 *          继承JpaRepository<对象，主键>来完成对数据库的操作
 * @program: spring-boot-web
 * @author: 1260535819@qq.com
 * @create: 2020-05-10 07:13
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
