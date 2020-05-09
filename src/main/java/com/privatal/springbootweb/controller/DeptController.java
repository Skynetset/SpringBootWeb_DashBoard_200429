package com.privatal.springbootweb.controller;

import com.privatal.springbootweb.entities.Department;
import com.privatal.springbootweb.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO DeptController
 *
 * @program: spring-boot-web
 * @author: 1260535819@qq.com
 * @create: 2020-05-09 14:46
 */
@RestController
public class DeptController {
    @Autowired
    DepartmentMapper departmentMapper;

    @RequestMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @RequestMapping("/dept")
    public Department getDepartment(Department department){
        departmentMapper.insertDept(department);
        return department;
    }
}
