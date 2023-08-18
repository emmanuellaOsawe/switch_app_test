package com.interswitch;

import com.interswitch.model.Department;
import com.interswitch.model.Salary;
import com.interswitch.repository.DepartmentRepository;
import com.interswitch.repository.SalaryRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info =
	@Info(title = "Salary API", version = "1.0", description = "Documentation Salary API v1.0")
)
public class SalaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalaryApplication.class, args);
	}

	@Bean
	SalaryRepository SalaryRepository() {
		SalaryRepository repository = new SalaryRepository();
		repository.add(new Salary(1L, 5L, Double.valueOf(40), LocalDate.now() ));
		repository.add(new Salary(2L, 6L, Double.valueOf(50), LocalDate.now() ));
		repository.add(new Salary(3L, 7L, Double.valueOf(60), LocalDate.now() ));
		repository.add(new Salary(4L, 8L, Double.valueOf(70), LocalDate.now() ));
		return repository;
	}

	@Bean
	DepartmentRepository repository(){
		DepartmentRepository repository = new DepartmentRepository();
		repository.add(new Department(1L, "Development"));
		repository.add(new Department(1L, "Operations"));
		repository.add(new Department(1L, "Development"));
		repository.add(new Department(1L, "Operations"));
		return repository;
	}

}
