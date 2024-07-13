package com.microservices.employee.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.employee.client.DepartmentClient;
import com.microservices.employee.entity.Employee;
import com.microservices.employee.model.DepartmentModel;
import com.microservices.employee.model.EmployeeModel;
import com.microservices.employee.model.EmployeeWithDepartment;
import com.microservices.employee.repository.EmployeeRepository;
import com.microservices.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	DepartmentClient deptClient;

	@Override
	public Employee saveEmployee(EmployeeModel model) {

		Employee entity = null;
		try {
			entity = new Employee();
			BeanUtils.copyProperties(model, entity);
		} catch (BeansException e) {
			e.printStackTrace();
		}

		return empRepo.save(entity);
	}

	@Override
	public List<EmployeeWithDepartment> getAllEmployees() {
		
		List<Employee> empList=empRepo.findAll();
		
		 List<EmployeeWithDepartment> edList = empList.stream()
	                .map(emp -> {
	                	DepartmentModel dept = deptClient.getDepartmentDetails(emp.getDeptId());
	                    return new EmployeeWithDepartment(emp.getEmpId(), emp.getEmpName(),emp.getSalary(), dept);
	                })
	                .collect(Collectors.toList());		
		
		return edList;
	}

}
