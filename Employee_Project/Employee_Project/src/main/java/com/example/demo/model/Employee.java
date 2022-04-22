package com.example.demo.model;

import lombok.*;

import java.util.Objects;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    int id;
   String name;
    int age;
    int salary;


}
