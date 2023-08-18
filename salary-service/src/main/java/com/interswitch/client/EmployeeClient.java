package com.interswitch.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.interswitch.model.Employee;

@FeignClient(name = "employee-service")
public interface EmployeeClient {
	@GetMapping("/department/{departmentId}")
	List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId);

	@GetMapping("/salary/{salaryId}")
	List<Employee> findBySalary(@PathVariable("salaryId") Long salaryId);
	
}
