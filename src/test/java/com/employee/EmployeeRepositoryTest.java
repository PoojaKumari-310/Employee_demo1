package com.employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
public void givenEmployeeShouldReturnEmployeeObject()
    {
        Employee e1 = new Employee(3L,"priya",2);
        employeeRepository.save(e1);

        Employee e2 = employeeRepository.findById(e1.getEmployeeId()).get();
        assertNotNull(e2);

        assertEquals(e1.getName(),e2.getName());
    }
    @Test
    public void getAllMustReturnAllEmployee() {
        Employee e3 = new Employee(4L,"neha",3);
        employeeRepository.save(e3);

        Employee e4 = new Employee(5L,"priyansh",4);
        employeeRepository.save(e4);

    }

    @Test
    void testSaveEmployee()
    {
        Employee e2 = new Employee(4L,"neha",3);
        employeeRepository.save(e2);
        Employee newEmployee =employeeRepository.findById(e2.getEmployeeId()).get();
        assertNotNull(newEmployee);
        assertEquals(e2.getEmployeeId(), newEmployee.getEmployeeId());

    }


    @Test
    void testDeleteEmployee() {
        Employee e4 = new Employee(6L,"pakhi",5);
        employeeRepository.save(e4);
        employeeRepository.delete(e4);
        assertEquals(employeeRepository.findById(6L), Optional.empty());

    }
}