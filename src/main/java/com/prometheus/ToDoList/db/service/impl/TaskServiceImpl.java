package com.prometheus.ToDoList.db.service.impl;

import com.prometheus.ToDoList.db.repository.TaskRepository;
import com.prometheus.ToDoList.db.service.api.TaskService;
import com.prometheus.ToDoList.domain.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return taskRepository.get(id); // id
    }

    @Override
    public List<Task> getTaskByUserId(Integer userId) {
        return taskRepository.getTaskByUserId(userId);
    }

    @Override
    public Integer add(Task task) {
        return taskRepository.add(task);
    }

    @Override
    public void delete(Integer id) {
        taskRepository.delete(id);
    }

    @Override
    public void update(Integer id, Task task) {
        taskRepository.update(id, task);
    }


}
