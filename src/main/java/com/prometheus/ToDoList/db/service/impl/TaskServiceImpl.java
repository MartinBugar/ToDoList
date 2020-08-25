package com.prometheus.ToDoList.db.service.impl;

import com.prometheus.ToDoList.db.repository.TaskRepository;
import com.prometheus.ToDoList.db.service.api.TaskService;
import com.prometheus.ToDoList.domain.Task;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl (TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.getAll();
    }

    @Override
    public Task get(Integer id) {
        return taskRepository.get(id);
    }

    @Override
    public Integer add(Task task) {
        return taskRepository.add(task);
    }

    @Override
    public void delete(Integer id) {
        taskRepository.delete(id);
    }

//    @Override
//    public void update(Integer id, UpdateTaskRequest updateTaskRequest) {
//
//    }
}
