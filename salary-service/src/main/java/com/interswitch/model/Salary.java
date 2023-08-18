package com.interswitch.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Salary {

    private Long id;
    private Long EmployeeId;
    private Double amount;
    private LocalDate date;

    private Long DepartmentId;

    private List<Employee> employees = new ArrayList<>();

    public Salary() {

    }

    public Salary(Long EmployeeId, Double amount, LocalDate date) {
        super();
        this.EmployeeId = EmployeeId;
        this.amount = amount;
        this.date = date;
    }

    public Salary(Long id, Long EmployeeId, Double amount, LocalDate date) {
        super();
        this.id = id;
        this.EmployeeId = EmployeeId;
        this.amount = amount;
        this.date = date;
    }

    public Salary(Long id, Long EmployeeId, Double amount, LocalDate date, Long DepartmentId) {
        super();
        this.id = id;
        this.EmployeeId = EmployeeId;
        this.amount = amount;
        this.date = date;
        this.DepartmentId = DepartmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(List<Employee> bySalary) {
        this.EmployeeId = EmployeeId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount() {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return LocalDate.now();
    }

    public void setDate() {
        this.date = LocalDate.now();
    }

    public Long getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.DepartmentId = DepartmentId;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", EmployeeId=" + EmployeeId +
                ", amount=" + amount +
                ", date=" + date +
                ", DepartmentId=" + DepartmentId +
                ", employees=" + employees +
                '}';
    }
}
