package com.kafka.consumer.service;

import com.kafka.consumer.entity.Employee;
import com.kafka.consumer.repo.EmployeeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeService {

    Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepo employeeRepo;

    public void addEmployee(List<Employee> employees){
        HashMap<String, Boolean> rowUpdateStatusMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(employees)){
            for(Employee employee : employees){
                Employee saveEmployee = null;
                try {
//                    track the updated date in the table
                    employee.setUpdatedDate(new Date());
                    saveEmployee = employeeRepo.save(employee);
                    rowUpdateStatusMap.put(saveEmployee.getId(), true);
                    logger.info("employee with id "+ employee.getId() + " is saved in DB ");
                }catch (Exception e){
                    logger.error("employee with id "+ employee.getId() + " is not saved in DB ");
                    rowUpdateStatusMap.put(saveEmployee.getId(), false);
                    e.printStackTrace();
                }
            }
        }
    }

    public Employee addEmployee(Employee employee) {
        employee.setUpdatedDate(new Date());
        return employeeRepo.save(employee);
    }
}
