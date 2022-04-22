package com.example.demo.Service;

import com.example.demo.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;

import java.util.List;


public interface EmployeeService {
    List<Employee> getAllEmployeeDetails();

    Employee addEmployee(Employee employee);

    List<Employee> getListAfterDeleteOfEmployeeById(int id);

    Employee getMaximumSalaryEmployee();

    Employee getMinimumSalaryEmployee();
}
