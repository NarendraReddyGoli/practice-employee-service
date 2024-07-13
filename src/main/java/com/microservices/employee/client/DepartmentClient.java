package com.microservices.employee.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.microservices.employee.model.DepartmentModel;

@HttpExchange
public interface DepartmentClient {
	
	@GetExchange("/department/getDepartment/{deptId}")
	DepartmentModel getDepartmentDetails(@PathVariable Long deptId);

	

}
