package com.privatal.springbootweb.mapper;

import com.privatal.springbootweb.entities.Department;
import org.apache.ibatis.annotations.*;

/**
 * TODO DepartmentMapper
 *
 * @program: spring-boot-web
 * @author: 1260535819@qq.com
 * @create: 2020-05-09 14:36
 */
//@Mapper
public interface DepartmentMapper {

    @Select(value = "select * from department where id=#{id} ")
    public Department getDeptById(Integer id);

    @Delete(value = "delete from department where id=#{id} ")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert(value = "insert into department(departmentName) values (#{departmentName})")
    public int insertDept(Department department);

    @Update(value = "update department set departmentName=#{departmentName} where id=#{id} ")
    public int updateDept(Department department);
}
