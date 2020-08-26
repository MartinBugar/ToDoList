package com.prometheus.ToDoList.db.service.api;

import com.prometheus.ToDoList.domain.User;

import java.util.List;

public interface UserService {

    List<User> getUsers (); // vrati vsetkych userov

    User get(Integer id); // vrati customera na zaklade id

    Integer add(User user); // prida usera a vrati jeho id

    void delete(Integer id);

    void update (Integer id, User user);


}
