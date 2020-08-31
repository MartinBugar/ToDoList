package com.prometheus.ToDoList.mvcController;

import com.prometheus.ToDoList.db.repository.UserRepository;
import com.prometheus.ToDoList.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcUserController {

    UserRepository userRepository;

    public MvcUserController(UserRepository userRepository){
        this.userRepository =userRepository;
    }

    @RequestMapping("/users")
    public String getUserIndex(Model model){
        model.addAttribute("users", userRepository.getAll());
        return "users";
    }



}
