package com.microservices.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeWithDepartment {

	private Long empId;
	private String empName;
	private double salary;
	private DepartmentModel dept;

}
