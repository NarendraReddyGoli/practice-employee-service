package com.microservices.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Setter
@Getter
public class Employee {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "EMP_ID")
private Long empId;
@Column(name = "EMP_NAME")
private String empName;
@Column(name = "EMP_SALARY")
private double salary;
@Column(name = "DEPARTMENT_ID")
private Long deptId;


}
