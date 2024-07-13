package com.microservices.employee.controller;

import java.util.List;

import com.microservices.employee.entity.Employee;
import com.microservices.employee.model.EmployeeModel;
import com.microservices.employee.model.EmployeeWithDepartment;

public interface EmployeeController {
	String getEmployeeName();
	Employee saveEmployee(EmployeeModel model);
	List<EmployeeWithDepartment> getAllEmployees();
}
