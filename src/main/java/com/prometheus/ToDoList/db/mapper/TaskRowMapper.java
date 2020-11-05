package com.prometheus.ToDoList.db.mapper;


import com.prometheus.ToDoList.domain.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper <Task> {
    @Override
    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        Task task = new Task();
        task.setId(resultSet.getInt("id")); //na zaklade "id" sa vyberie integer id
        task.setUserId(resultSet.getInt("userId")); //na zaklade "userId" sa vyberie integer userId
        task.setName(resultSet.getString("name")); //na zaklade "name" sa vyberie String name
        task.setStatus(resultSet.getInt("status")); //na zaklade "status" sa vyberie integer status
        task.setCategory(resultSet.getString("category")); //na zaklade "category" sa vyberie String category
        task.setDescription(resultSet.getString("description")); //na zaklade "description" sa vyberie String description
        task.setCreatedAt(resultSet.getTimestamp("createdAt")); //na zaklade "createdAt" sa vyberie createdAt
        return task;
    }
}
