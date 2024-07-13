package com.microservices.employee.controllerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.employee.controller.EmployeeController;
import com.microservices.employee.entity.Employee;
import com.microservices.employee.model.EmployeeModel;
import com.microservices.employee.model.EmployeeWithDepartment;
import com.microservices.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeControllerImpl implements EmployeeController{

	@Autowired
	EmployeeService service;
	@Override
	@GetMapping("/getEmployeeName")
	public String getEmployeeName() {
		System.out.println("Enters into the employeee getEmployeeName() :: ");
		return "John";
	}

	@Override
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody EmployeeModel model) {
		// TODO Auto-generated method stub
		return service.saveEmployee(model);
	}

	@Override
	@GetMapping("/getAllEmployees")
	public List<EmployeeWithDepartment> getAllEmployees() {
		return service.getAllEmployees();
	}

}
