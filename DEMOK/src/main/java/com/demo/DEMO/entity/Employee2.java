package com.demo.DEMO.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(indexName = "employee1")
public class Employee2 {

    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private int salary;
}
