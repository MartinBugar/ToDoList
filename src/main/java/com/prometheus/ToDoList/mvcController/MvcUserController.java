package com.prometheus.ToDoList.mvcController;

import com.prometheus.ToDoList.db.repository.UserRepository;
import com.prometheus.ToDoList.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MvcUserController {
    @Autowired(required=true)
    @Qualifier(value="userRepository")
    UserRepository userRepository;

    public MvcUserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }



    @RequestMapping(value = ("/users"), method = RequestMethod.GET)
    public String getUserIndex(Model model){
        model.addAttribute("users", userRepository.getAll());
        return "users";
    }





}
