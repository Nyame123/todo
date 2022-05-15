package com.bismark.todo.controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.bismark.models.User;
import com.repositories.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan("com.repositories")
@RestController
public class LoginController {
    
   // @Autowired
    LoginRepository loginRepository;

    @GetMapping("/saveBulkUsers")
    public String saveBulkyUsers(){
        List<User> users = Arrays.asList(
            new User("Kyeame","lionello","Bismark",new Date().getTime()),
            new User("Kwame","lion","Bismark",new Date().getTime())
        );
        loginRepository.saveAll(users);

        return "successfully created users";
    }
}
