package com.example.demo.controller;

import com.example.demo.Service.EmployeeService;
import com.example.demo.Service.EmployeeServiceImpl;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {


    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }

    @GetMapping("/employee")
    private Flux<ResponseEntity<Employee>> getAllEmployee ()
    {
        return Flux.fromIterable(employeeService.getAllEmployeeDetails())
                .map(n-> ResponseEntity.ok(n))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/employee")
    private Mono<ResponseEntity<Employee>> addEmployee(@RequestBody Employee employee)
    {
        return Mono.just(employeeService.addEmployee(employee))
                .map(n-> ResponseEntity.ok(n))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/employee/{id}")
    private Flux<ResponseEntity<Employee>> deleteEmployeeById(@PathVariable int id)
    {
        return Flux.fromIterable(employeeService.getListAfterDeleteOfEmployeeById(id))
                .map(n->ResponseEntity.ok(n))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/employee/max")
    private Mono<ResponseEntity<Employee>> getMaximumSalaryEmployeeDetail()
    {
        return Mono.just(employeeService.getMaximumSalaryEmployee())
                .map(n->ResponseEntity.ok(n))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/employee/min")
    private Mono<ResponseEntity<Employee>> getMiniimumSalaryEmployeeDetail()
    {
        return Mono.just(employeeService.getMinimumSalaryEmployee())
                .map(n->ResponseEntity.ok(n))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
