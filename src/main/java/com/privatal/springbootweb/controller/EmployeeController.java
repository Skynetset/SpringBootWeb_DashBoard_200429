package com.privatal.springbootweb.controller;

import com.privatal.springbootweb.dao.DepartmentDao;
import com.privatal.springbootweb.dao.EmployeeDao;
import com.privatal.springbootweb.entities.Department;
import com.privatal.springbootweb.entities.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
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
        employeeDao.save(employee);
        logger.debug(employee.toString());
        return "redirect:/emps";
    }

    @PutMapping("/emp")
    public String modifyEmp(Employee employee){
        employeeDao.save(employee);
        logger.debug(employee.toString());
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee =employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
