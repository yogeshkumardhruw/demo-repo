package com.demo.DEMO.controller;

import com.demo.DEMO.entity.Employee;
import com.demo.DEMO.service.ConsumerEmployeeService;
import com.demo.DEMO.service.ProducerEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private ProducerEmployeeService producerEmployeeService;

//    @Autowired
//    private ConsumerEmployeeService consumerEmployeeService;

    @PostMapping("/produce")
    public void sendMsg(@RequestBody Employee employee){
        producerEmployeeService.sendMsg(employee);
    }

//    @GetMapping("/getMongo")
//    public List<Employee> getFromMongoDB(){
//        return consumerEmployeeService.getFromMongoDB();
//    }
//
//    @GetMapping("/getElastic")
//    public Iterable<Employee> getFromElastic(){
//        return consumerEmployeeService.getFromElastic();
//    }
}
