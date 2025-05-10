package com.kafka.consumer.service;

import com.common.dto.UserDto;
import com.kafka.consumer.constant.ConsumerTopic;
import com.kafka.consumer.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaUpdateEmployeeListner {

//    @KafkaListener(topics = "msg-topic_2", groupId = "con-2")
//    public void consumerMessage(String message){
////        log.info("consume the message "+ message);
//        System.out.println("consume the message "+ message);
//    }

    @Autowired
    private EmployeeService employeeService;

    @KafkaListener(topics = ConsumerTopic.UPDATE_USER_TOPIC, groupId = "con-2")
    public void consumerUser(UserDto userDto){
        Employee employee = toEmployee(userDto);
        if (employee != null){
            if (employeeService.addEmployee(employee)!=null){
                System.out.println("employee is saved and is from city"+ employee.getCity());
            }
        }
    }

    public  Employee toEmployee(UserDto dto) {
        Employee emp = new Employee();
        emp.setId(dto.getId());
        emp.setGender(dto.getGender());
        emp.setAge(dto.getAge());
        emp.setProfession(dto.getProfession());
        emp.setAcademicPressure(dto.getAcademicPressure());
        emp.setWorkPressure(dto.getWorkPressure());
        emp.setCGPA(dto.getCGPA());
        emp.setStudySatisfaction(dto.getStudySatisfaction());
        emp.setJobSatisfaction(dto.getJobSatisfaction());
        emp.setSleepDuration(dto.getSleepDuration());
        emp.setDietaryHabits(dto.getDietaryHabits());
        emp.setDegree(dto.getDegree());
        emp.setSuicidal(dto.getSuicidal());
        emp.setStudyHour(dto.getStudyHour());
        emp.setMentalIllnessHistory(dto.getMentalIllnessHistory());
        emp.setDepression(dto.getDepression());
        emp.setFinancialStress(dto.getFinancialStress());
        emp.setCity(dto.getCity());
        emp.setWorkStudyHours(dto.getWorkStudyHours());
        return emp;
    }

}
