package com.microservices.controllerImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.controller.EmployeeController;

@RestController
@RequestMapping("/employee")
public class EmployeeControllerImpl implements EmployeeController{

	@Override
	@GetMapping("/getEmployeeName")
	public String getEmployeeName() {
		System.out.println("Enters into the employeee getEmployeeName() :: ");
		return "John";
	}

}
