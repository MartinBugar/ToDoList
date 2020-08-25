package com.prometheus.ToDoList.db.service.impl;

import com.prometheus.ToDoList.db.service.api.TaskService;
import com.prometheus.ToDoList.domain.Task;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    @Override
    public List<Task> getTasks() {
        return null;
    }

    @Override
    public Task get(Integer id) {
        return null;
    }

    @Override
    public Integer add(Task task) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Integer id, UpdateTaskRequest updateTaskRequest) {

    }
}
