package com.kafka.consumer.controller;

import com.kafka.consumer.entity.Employee;
import com.kafka.consumer.service.EmployeeService;
import jakarta.el.ELManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/consumer")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public void addEmployee(@RequestBody List<Employee> employees){
        employeeService.addEmployee(employees);
    }
}
