package com.prometheus.ToDoList.db.repository;

import com.prometheus.ToDoList.db.mapper.UserRowMapper;
import com.prometheus.ToDoList.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;


@Component
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper userRowMapper = new UserRowMapper();

    public UserRepository (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAll (){
        final String sql = "select * from user";
        return jdbcTemplate.query(sql, userRowMapper);
    }


    public User get(Integer id){
        final String sql = "select * from user where user.id = " + id;

        try {
            return jdbcTemplate.queryForObject(sql,userRowMapper);
        } catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    public Integer add(User user) {
        final String sql = "insert into user (name, surname, nickname, email, age, password) values (?,?,?,?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getName());
                ps.setString(2, user.getSurname());
                ps.setString(3, user.getNickName());
                ps.setString(4, user.getEmail());

                if (user.getAge() != null) {
                    ps.setInt(5, user.getAge());
                } else {
                    ps.setNull(5, Types.INTEGER);
                }

                ps.setString(6, user.getPassword());
                return ps;
            }
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            return keyHolder.getKey().intValue();
        } else {
            return null;
        }

    }

    public void delete(Integer id){
        final String sql = "delete from user where id = ?";
            jdbcTemplate.update(sql,id);
    }


//    public User update (User user, Integer id){
//
//    }




}
