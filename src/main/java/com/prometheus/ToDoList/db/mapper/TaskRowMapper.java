package com.prometheus.ToDoList.db.mapper;


import com.prometheus.ToDoList.domain.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper <Task> {
    @Override
    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        Task task = new Task();
        task.setId(resultSet.getInt("id"));
        task.setName(resultSet.getString("name"));
        task.setCategory(resultSet.getString("category"));
        task.setDescription(resultSet.getString("description"));
        task.setStatus(resultSet.getInt("status"));
        task.setUserId(resultSet.getInt("userId"));
        task.setCreatedAt(resultSet.getTimestamp("createdAt"));

        return task;
    }
}
