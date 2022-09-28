package com.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/view/all")
    public List<Employee> fetchAllEmployees() {
        List<Employee> employeeList = employeeService.getAllEmployees();
        return employeeList;
    }

    @GetMapping("/view/{employeeId}")
    public ResponseEntity<Employee> fetchEmployeeDetails(@PathVariable("employeeId") long employeeId) {

        Employee employee = employeeService.getEmployeeById(employeeId);
        ResponseEntity<Employee> responseEntity = new ResponseEntity<>(employee, HttpStatus.OK);
        return responseEntity;

    }

    @PostMapping("/save")
    public ResponseEntity<Employee> addCourse( @Validated @RequestBody Employee employee) {

        Employee newEmployee = employeeService.saveEmployee(employee);
        ResponseEntity<Employee> responseEntity = new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
        return responseEntity;
    }
    @PostMapping("/update")
    public ResponseEntity<Employee> modifyEmployee(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(employee);
      ResponseEntity<Employee> responseEntity = new ResponseEntity<>(employee,HttpStatus.CREATED);
      return responseEntity;
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<String> removeEmployee(@PathVariable("employeeId") long employeeId) {
        employeeService.deleteEmployee(employeeId);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Employee Deleted Successfully.", HttpStatus.OK);
        return responseEntity;
    }


}

