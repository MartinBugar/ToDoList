package com.prometheus.ToDoList.db.service.impl;

import com.prometheus.ToDoList.db.repository.UserRepository;
import com.prometheus.ToDoList.db.service.api.UserService;
import com.prometheus.ToDoList.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl (UserRepository userRepository){
        this.userRepository = userRepository;
    }



    @Override
    public List<User> getUsers() {
        return userRepository.getAll() ;
    }

    @Override
    public User get(Integer id) {
        return userRepository.get(id);
    }

    @Override
    public Integer add(User user) {
        return userRepository.add(user);
    }
}
