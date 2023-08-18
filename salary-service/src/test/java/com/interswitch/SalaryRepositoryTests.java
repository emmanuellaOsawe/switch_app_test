//package com.interswitch;
//
//import com.interswitch.model.Salary;
//import com.interswitch.repository.SalaryRepository;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.springframework.util.Assert;
//
//import java.time.LocalDate;
//import java.util.List;
//
//public class SalaryRepositoryTests {
//
//    private static final SalaryRepository repository = new SalaryRepository();
//
//    @Test
//    @Order(1)
//    void testAddSalary1() {
//        Salary salary = new Salary(2L, Double.valueOf(678.90), LocalDate.parse("2022-04-13"));
//        salary = repository.add(salary);
//        Assert.notNull(salary, "Salaary is Null");;
//        Assert.isTrue(salary.getEmployeeId() == 2L, "Salary bad id.");
//    }
//    @Order(2)
//    void testAddSalary() {
//        Salary salary = new Salary(3L, Double.valueOf(675.90), LocalDate.parse("2022-04-13"));
//        salary = repository.add(salary);
//        Assert.notNull(salary, "Salary is Null");
//        Assert.isTrue(salary.getEmployeeId() == 3L, "Salary bad id");
//    }
//
//    @Test
//    @Order(3)
//    void testFindAll() {
//        testAddSalary1();
//
//        List<Salary> salaries = repository.findAll();
//        System.out.println(salaries.size());
//        Assert.isTrue(salaries.size() == 2, "Salary size is wrong");
//        Assert.isTrue(salaries.get(0).getEmployeeId() == 2L, "EmployeeId is bad");
//    }
//
//    @Test
//    @Order(4)
//    void testFindByOrganization() {
//        testAddSalary1();
//        testAddSalary1();
//        testAddSalary1();
//        testAddSalary();
//        List<Salary> salaries = repository.findByEmployeeId(3L);
//        Assert.isTrue(salaries.size() == 1, "Salary size is wrong");
//    }
//
//    @Test
//    @Order(5)
//    void testFindById() {
//        testAddSalary1();
//
//        Salary salary = repository.findById(1L);
//        Assert.notNull(salary, "Department not found");
//        Assert.isTrue((salary.getId() = 1L, "Department bad id"));
//    }
//}
