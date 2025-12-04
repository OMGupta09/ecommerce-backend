package com.om.ecommerce.service;

import com.om.ecommerce.Repository.UserRepository;
import com.om.ecommerce.entity.User;
import com.om.ecommerce.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository repo, JwtUtil jwtUtil) {
        this.repo = repo;
        this.jwtUtil = jwtUtil;
    }

    public User register(User user) {

        User existingUser = repo.findByEmail(user.getEmail());
        if (existingUser != null) {
            return null; // email exists
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashed = encoder.encode(user.getPassword());
        user.setPassword(hashed);

        user.setRole("USER");

        return repo.save(user);
    }

    public String login(String email, String password) {

        User user = repo.findByEmail(email);

        if (user == null) {
            return null; // email not found
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (!encoder.matches(password, user.getPassword())) {
            return null; // wrong password
        }

        // generate and return token
        return jwtUtil.generateToken(email, user.getRole());
    }
}
