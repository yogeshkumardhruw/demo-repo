package com.demo.DEMO.controller;

import com.demo.DEMO.entity.Employee;
import com.demo.DEMO.entity.Employee2;
import com.demo.DEMO.service.ConsumerEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/con")
public class ConsumerEmployeeController {


    @Autowired
    private ConsumerEmployeeService consumerEmployeeService;

    @GetMapping("/getMongo")
    public List<Employee> getFromMongoDB(){
        return consumerEmployeeService.getFromMongoDB();
    }

    @GetMapping("/getElastic")
    public Iterable<Employee2> getFromElastic(){
        return consumerEmployeeService.getFromElastic();
    }
}
