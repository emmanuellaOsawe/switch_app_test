package com.interswitch.service.task.repository;

import com.interswitch.service.task.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private List<Task> tasks = new ArrayList<>();

    public Task add(Task task) {
        task.setId((long) (tasks.size()+1));
        tasks.add(task);
        return task;
    }

    public Task findById(Long id) {
        return tasks.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Task> findAll() {
        return tasks;
    }

    public List<Task> findByOrganization(Long organizationId) {
        return tasks.stream()
                .filter(a -> a.getOrganizationId().equals(organizationId))
                .toList();
    }

}
