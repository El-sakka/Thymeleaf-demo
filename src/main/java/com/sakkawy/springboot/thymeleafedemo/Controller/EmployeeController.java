package com.sakkawy.springboot.thymeleafedemo.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.sakkawy.springboot.thymeleafedemo.model.Employee;
import com.sakkawy.springboot.thymeleafedemo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String listEmployees(Model model) {
        // get the employees from database 
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }
    
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        // save the employee
        employeeService.save(employee);
        // use a redirect to prevent dublicate submissions
        return "redirect:/employees/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
        // get the employee from service 
        Employee employee = employeeService.findById(id);
        // set employee as a model attribute to pre-populate the form 
        model.addAttribute("employee", employee);
        // send over to our form 
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id, Model model){
        // delete the employee
        employeeService.deleteById(id);
        // redirect to /employees/list
        return "redirect:/employees/list";
    }
}
