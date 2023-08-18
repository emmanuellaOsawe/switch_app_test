package com.interswitch.controller;

import com.interswitch.client.DepartmentClient;
import com.interswitch.client.EmployeeClient;
import com.interswitch.model.Department;
import com.interswitch.model.Salary;
import com.interswitch.repository.SalaryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalaryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SalaryController.class);

    SalaryRepository repository;
    EmployeeClient employeeClient;

    DepartmentClient departmentClient;

    public SalaryController(SalaryRepository repository, EmployeeClient employeeClient) {
        this.repository = repository;
        this.employeeClient = employeeClient;
    }

    @PostMapping("/")
    public Salary add(@RequestBody Salary salary) {
        LOGGER.info("Salary add : {}", salary);
        return repository.add(salary);
    }

    @GetMapping("/")
    public List<Salary> findAll() {
        LOGGER.info("Salary find");
        return repository.findAll();
    }

    @GetMapping("/employee/{EmployeeId}")
    public List<Salary> findByEmployeeId(@PathVariable("EmployeeId") Long EmployeeId) {
        LOGGER.info("Employee find: EmployeeIdd={}", EmployeeId);
        return repository.findByEmployeeId(EmployeeId);
    }

    @GetMapping("/employee/{EmployeeId}/with-employees")
    public List<Salary> findByEmployeeWithEmployees(@PathVariable("EmployeeId") Long EmployeeId) {
        LOGGER.info("Employee find: EmployeeId={}", EmployeeId);
        List<Salary> salaries = repository.findByEmployeeId(EmployeeId);
        salaries.forEach(f -> f.setEmployeeId(employeeClient.findBySalary(f.getId())));
        return salaries;
    }

    @GetMapping("/salary/{EmployeeId}/{DepartmentId}")
    public Salary addDepartment(@PathVariable Long EmployeeId, @PathVariable Long DepartmentId) throws Exception {
        Department department = departmentClient.findById(DepartmentId);
        if (department == null) {
            throw new Exception("no such department found");
        }
        return repository.setDepartmentId(EmployeeId, DepartmentId);
    }
}
