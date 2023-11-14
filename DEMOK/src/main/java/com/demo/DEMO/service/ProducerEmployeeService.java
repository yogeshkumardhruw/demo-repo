package com.demo.DEMO.service;

import com.demo.DEMO.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerEmployeeService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMsg(Employee employee){
        ObjectMapper om=new ObjectMapper();
        try {
            String emp = om.writeValueAsString(employee);
            kafkaTemplate.send("demok-topic", emp);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
