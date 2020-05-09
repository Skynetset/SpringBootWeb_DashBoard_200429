package com.privatal.springbootweb.controller;

import com.privatal.springbootweb.entities.Employee;
import com.privatal.springbootweb.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @program: spring-boot-web
 * @description: TODO EmployeeController
 * @author: 1260535819@qq.com
 * @create: 2020-04-30 08:56
 */
@Controller
public class EmployeeController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/emps")
    public String list(Model model){
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        return "emp/add";
    }

   /**
    * @Description : TODO
    * @Author : 1260535819@qq.com
    * @Date : 30/4/2020 下午3:04
    * @param employee :
    * @return : java.lang.String
    */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        return "redirect:/emps";
    }

    @PutMapping("/emp")
    public String modifyEmp(Employee employee){
        return "redirect:/emps";
    }

    @ResponseBody
    @GetMapping("/emp/{id}")
    public Employee toEditPage(@PathVariable("id") Integer id,Model model){
        return employeeMapper.getEmpById(id);
//        return "emp/add";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        return "redirect:/emps";
    }
}
