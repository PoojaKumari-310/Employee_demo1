package com.employee;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table (name = "employee_tbl")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long employeeId;
    @Column(name = "name")
    private String name;
    @Column(name = "departmentId")
    private int departmentId;
}




//    public <Employee> List<Employee> getAllDepartments() {
//    }
//}

