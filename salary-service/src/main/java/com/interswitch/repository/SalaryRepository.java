package com.interswitch.repository;

import com.interswitch.model.Salary;

import java.util.ArrayList;
import java.util.List;

public class SalaryRepository {

    private List<Salary> salaries = new ArrayList<>();

    public Salary add(Salary salary) {
        salary.setId((long) (salaries.size()+1));
        salaries.add(salary);
        return salary;
    }

    public Salary findById(Long id) {
        return salaries.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Salary> findAll() {
        return salaries;
    }

    public List<Salary> findByEmployeeId(Long EmployeeId) {
        return salaries.stream()
                .filter(f -> f.getEmployeeId().equals(EmployeeId))
                .toList();
    }

    public Salary setDepartmentId( Long EmployeeId, Long DepartmentId) {
        for (Salary s : salaries) {
            if (s.getEmployeeId() == EmployeeId)
                s.setDepartmentId(DepartmentId);
            return s;
        }
        return null;
    }
}
