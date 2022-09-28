package com.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public Employee getEmployeeById(long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee Not existing with id:" + employeeId);
        }
        Employee employee = optionalEmployee.get();
        return employee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        return newEmployee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getEmployeeId());

        if (optionalEmployee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee Not found with id: " + employee.getEmployeeId());
        }

        Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }

    @Override
    public void deleteEmployee(long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee Not found with id: " + employeeId);
        }

        employeeRepository.deleteById(employeeId);
    }
}
