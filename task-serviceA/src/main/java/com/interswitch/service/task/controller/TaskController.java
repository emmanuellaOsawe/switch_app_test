package com.interswitch.service.task.controller;

import com.interswitch.service.task.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.interswitch.service.task.client.TaskClient;
import com.interswitch.service.task.model.Task;

import java.util.List;

@RestController
public class TaskController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    TaskRepository repository;
    TaskClient taskClient;

    public TaskController(TaskRepository repository, TaskClient taskClient) {
        this.repository = repository;
        this.taskClient = taskClient;
    }

    @PostMapping("/")
    public Task add(@RequestBody Task task) {
        LOGGER.info("Task add: {}", task);
        return repository.add(task);
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable("id") Long id) {
        LOGGER.info("Task find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/")
    public List<Task> findAll() {
        LOGGER.info("Task find");
        return repository.findAll();
    }

    @GetMapping("/organization/{organizationId}")
    public List<Task> findByOrganization(@PathVariable("organizationId") Long organizationId) {
        LOGGER.info("Task find: organizationId={}", organizationId);
        return repository.findByOrganization(organizationId);
    }

    @GetMapping("/organization/{organizationId}/with-employees")
    public List<Task> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {
        LOGGER.info("Task find: organizationId={}", organizationId);
        List<Task> tasks = repository.findByOrganization(organizationId);
        tasks.forEach(d -> d.setEmployees(taskClient.findByTask(d.getId())));
        return tasks;
    }

}
