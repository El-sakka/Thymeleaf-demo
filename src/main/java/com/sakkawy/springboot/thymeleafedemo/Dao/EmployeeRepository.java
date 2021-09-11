package com.sakkawy.springboot.thymeleafedemo.Dao;

import com.sakkawy.springboot.thymeleafedemo.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    
}
