package com.sakkawy.springboot.thymeleafedemo.service;

import java.util.List;

import com.sakkawy.springboot.thymeleafedemo.model.Employee;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int id);

    public void save (Employee employee);
    
    public void deleteById(int id);

}
