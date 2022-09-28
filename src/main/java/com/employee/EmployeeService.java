package com.employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(long employeeId);

    public Employee saveEmployee(Employee employee);

    public Employee updateEmployee(Employee employee);

    public void deleteEmployee(long employeeId);

}
