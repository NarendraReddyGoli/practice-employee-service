package com.microservices.employee.model;

import lombok.Data;

@Data
public class EmployeeModel {
private Long empId;
private String empName;
private double salary;
private Long deptId;

}
