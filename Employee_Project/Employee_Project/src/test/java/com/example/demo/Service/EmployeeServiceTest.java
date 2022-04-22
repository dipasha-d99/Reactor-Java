package com.example.demo.Service;

import com.example.demo.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)

public class EmployeeServiceTest {
    @Mock
    private EmployeeService employeeService;

    @Test
    public void getAllEmployeeDetailsTest()
    {
        List<Employee> employeesMock=List.of(new Employee(5,"ABC",25,25000));

        Mockito.when(employeeService.getAllEmployeeDetails()).thenReturn(employeesMock);
        EmployeeServiceImpl employeeServiceimpl=new EmployeeServiceImpl();
        assertEquals(employeeServiceimpl.getAllEmployeeDetails().toString(),"[Employee(id=1, name=Jason Stanley, age=35, salary=50000), Employee(id=2, name=Brad lernar, age=25, salary=56000), Employee(id=3, name=Jasmine Decosta, age=40, salary=45000), Employee(id=4, name=Freddy Thomas, age=27, salary=60000), Employee(id=5, name=Hale Berry, age=32, salary=54000)]");
    }

    @Test
    public void addEmployeeTest()
    {
        Employee employee=new Employee(5,"ABC",25,25000);
        System.out.println(employee);
        Mockito.when(employeeService.addEmployee(employee)).thenReturn(employee);
        EmployeeServiceImpl employeeServiceimpl=new EmployeeServiceImpl();
        assertEquals(employeeServiceimpl.addEmployee(employee).toString(),"Employee(id=5, name=ABC, age=25, salary=25000)");
    }


    @Test
    public void getAllEmployeeDetailsAfterDeleteByIdTest()
    {
        List<Employee> employeesMock=List.of(new Employee(5,"ABC",25,25000));

        Mockito.when(employeeService.getListAfterDeleteOfEmployeeById(5)).thenReturn(employeesMock);
        EmployeeServiceImpl employeeServiceimpl=new EmployeeServiceImpl();
        assertEquals(employeeServiceimpl.getListAfterDeleteOfEmployeeById(5).toString(),"[Employee(id=1, name=Jason Stanley, age=35, salary=50000), Employee(id=2, name=Brad lernar, age=25, salary=56000), Employee(id=3, name=Jasmine Decosta, age=40, salary=45000), Employee(id=4, name=Freddy Thomas, age=27, salary=60000)]");
    }

    @Test
    public void getMaximumSalaryEmployeeDetailsTest()
    {
        Employee employee=new Employee(5,"ABC",25,25000);
        System.out.println(employee);
        Mockito.when(employeeService.getMaximumSalaryEmployee()).thenReturn(employee);
        EmployeeServiceImpl employeeServiceimpl=new EmployeeServiceImpl();
        assertEquals(employeeServiceimpl.getMaximumSalaryEmployee().toString(),"Employee(id=4, name=Freddy Thomas, age=27, salary=60000)");
    }

    @Test
    public void getMinimumSalaryEmployeeDetailsTest()
    {
        Employee employee=new Employee(5,"ABC",25,25000);
        System.out.println(employee);
        Mockito.when(employeeService.getMinimumSalaryEmployee()).thenReturn(employee);
        EmployeeServiceImpl employeeServiceimpl=new EmployeeServiceImpl();
        assertEquals(employeeServiceimpl.getMinimumSalaryEmployee().toString(),"Employee(id=3, name=Jasmine Decosta, age=40, salary=45000)");
    }

}
