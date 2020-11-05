package com.prometheus.ToDoList.db.repository;

import com.prometheus.ToDoList.db.mapper.TaskRowMapper;
import com.prometheus.ToDoList.domain.Task;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


@Component
public class TaskRepository  {

    private final JdbcTemplate jdbcTemplate;
    private final TaskRowMapper taskRowMapper = new TaskRowMapper();

    public TaskRepository (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public List <Task> getAll (){
        final String sql = "select * from task";
        return jdbcTemplate.query(sql,taskRowMapper);
    }


    //taskRowMapper mi na zaklade Stringov ulozenych v databaze vrati cely OBJEKT task
    //dany objekt, ktory ma byt vrateny je vybrany na zaklade vstupujuceho integeru id do metody
    public Task get (Integer id){ //vracia cely objekt task na zaklade idcka
        final String sql = "select * from task where task.id = " + id; //sql prikaz hlada task v databaze na zaklade id
        try {
            return jdbcTemplate.queryForObject(sql,taskRowMapper);  //vracia OBJEKT TASK
        } catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    public List<Task> getTaskByUserId (Integer userId){
        final String sql = "select * from task where task.userId = " + userId;
        try {
            return jdbcTemplate.query(sql,taskRowMapper);
        } catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    public Integer add (Task task){
        final String sql = "insert into task (userId, name, status, category, description, createdAt) values (?,?,?,?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1,task.getUserId());
                ps.setString(2,task.getName());
                ps.setInt(3,task.getStatus());
                ps.setString(4,task.getCategory());
                ps.setString(5,task.getDescription());
                ps.setTimestamp(6,task.getCreatedAt());
                return ps;
            }
        }, keyHolder);
        if (keyHolder.getKey() != null){
            return keyHolder.getKey().intValue();
        } else {
            return null;
        }
    }

    public void delete (Integer id){
        final String sql = "delete from task where id = ? " ;
        jdbcTemplate.update(sql,id);
    }

    public void update (Integer id, Task task){
        final String sql = "update task set name = ?,status = ?,category = ?,description = ? where id = ? ";
        jdbcTemplate.update(sql, task.getName(),task.getStatus(),task.getCategory(),task.getDescription(),id);
    }

}
