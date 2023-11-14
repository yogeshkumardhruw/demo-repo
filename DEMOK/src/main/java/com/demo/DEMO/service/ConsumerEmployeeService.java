package com.demo.DEMO.service;

import com.demo.DEMO.entity.Employee;
import com.demo.DEMO.entity.Employee2;
import com.demo.DEMO.repositories.ElasticEmployeeRepository;
import com.demo.DEMO.repositories.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerEmployeeService {

        @Autowired
    private EmployeeRepository employeeRepository;

        @Autowired
        private ElasticEmployeeRepository elasticEmployeeRepository;

    @KafkaListener(topics = "demok-topic", groupId = "group-1")
    public void getMsg(String employee){
        ObjectMapper om=new ObjectMapper();
        try {
            Employee employee1 = om.readValue(employee, Employee.class);
            Employee2 employee2 = om.readValue(employee, Employee2.class);
            employeeRepository.save(employee1);
            elasticEmployeeRepository.save(employee2);
            System.out.println(employee1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
//        employeeRepository.save(om.readValue(employee,Employee.class))
    }

    public List<Employee> getFromMongoDB(){
        return employeeRepository.findAll();
    }

    public Iterable<Employee2> getFromElastic(){
        return elasticEmployeeRepository.findAll();
    }

}
