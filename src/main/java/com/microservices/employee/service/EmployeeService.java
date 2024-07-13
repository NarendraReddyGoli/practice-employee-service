package com.microservices.employee.service;

import java.util.List;

import com.microservices.employee.entity.Employee;
import com.microservices.employee.model.EmployeeModel;
import com.microservices.employee.model.EmployeeWithDepartment;

public interface EmployeeService {
	
	Employee saveEmployee(EmployeeModel model);

	List<EmployeeWithDepartment> getAllEmployees();

}
