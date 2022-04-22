package com.example.demo.Service;

import com.example.demo.model.Employee;
import org.apache.catalina.connector.Response;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    List<Employee> employees=new ArrayList<>(List.of(
            Employee.builder().id(1).name("Jason Stanley").age(35).salary(50000).build(),
            Employee.builder().id(2).name("Brad lernar").age(25).salary(56000).build(),
            Employee.builder().id(3).name("Jasmine Decosta").age(40).salary(45000).build(),
            Employee.builder().id(4).name("Freddy Thomas").age(27).salary(60000).build(),
            Employee.builder().id(5).name("Hale Berry").age(32).salary(54000).build()
    ));


    @Override
    public List<Employee> getAllEmployeeDetails() {

        return employees;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getListAfterDeleteOfEmployeeById(int id) {
        employees=employees.stream().filter(emp->emp.getId()!=id).collect(Collectors.toList());
        return employees;
    }

    @Override
    public Employee getMaximumSalaryEmployee() {
        return employees.stream().max(Comparator.comparing(Employee::getSalary)).get();

    }

    @Override
    public Employee getMinimumSalaryEmployee() {
        return employees.stream().min(Comparator.comparing(Employee::getSalary)).get();
    }
}
