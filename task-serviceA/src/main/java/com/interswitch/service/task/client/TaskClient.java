package com.interswitch.service.task.client;

import java.util.List;

import com.interswitch.service.task.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import com.interswitch.service.task.model.Task;

@FeignClient(name = "employee-service")
public interface TaskClient {
    @GetMapping("/task/{taskId}")
    List<Employee> findByTask(@PathVariable("taskId") Long taskId);

}
