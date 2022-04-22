package com.example.demo.controller;



import com.example.demo.Service.EmployeeService;
import com.example.demo.Service.EmployeeServiceImpl;
import com.example.demo.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import javax.annotation.security.RunAs;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)

public class EmployeeControllerTest {



    @Mock
    private EmployeeService employeeService;

    @Test
    public void getResonseOfControllerGetEmployeeAllTest()
    {
        Employee employee=new Employee(5,"ABC",25,25000);
        System.out.println(employee);
        Mockito.when(employeeService.addEmployee(employee)).thenReturn(employee);

        assertEquals(employeeService.addEmployee(employee).toString(),"Employee(id=5, name=ABC, age=25, salary=25000)");

    }





}
