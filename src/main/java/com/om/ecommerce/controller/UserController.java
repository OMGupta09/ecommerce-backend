package com.om.ecommerce.controller;

import com.om.ecommerce.entity.User;
import com.om.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> request) {

        String email = request.get("email");
        String password = request.get("password");

        return service.login(email, password);
    }
}
