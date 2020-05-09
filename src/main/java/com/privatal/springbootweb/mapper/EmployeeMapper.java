package com.privatal.springbootweb.mapper;

import com.privatal.springbootweb.entities.Employee;

/**
 * TODO EmployeeMapper_XML
 *
 * @program: spring-boot-web
 * @author: 1260535819@qq.com
 * @create: 2020-05-09 15:18
 */
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void deleteEmpById(Integer id);

    public void insertEmp(Employee employee);

    public Employee updateEmp(Employee employee);

}
