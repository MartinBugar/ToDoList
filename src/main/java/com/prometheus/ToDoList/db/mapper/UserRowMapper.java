package com.prometheus.ToDoList.db.mapper;

import com.prometheus.ToDoList.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper <User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setEmail(resultSet.getString("email"));
        user.setNickName(resultSet.getString("nickName"));
        user.setAge(resultSet.getObject("age") == null ? null : resultSet.getInt("age"));

        return user;
    }
}
