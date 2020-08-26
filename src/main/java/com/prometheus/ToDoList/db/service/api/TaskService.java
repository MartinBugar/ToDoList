package com.prometheus.ToDoList.db.service.api;

import com.prometheus.ToDoList.domain.Task;

import java.util.List;

public interface TaskService {

    List<Task> getTasks(); // vracia vsetky tasky

    Task get(Integer id); // vrati task na zaklade id

    Integer add(Task task); // vracia vygenerovane id

    void delete(Integer id); // vymaze task na zaklade jeho id

    void update(Integer id, Task task);



}
