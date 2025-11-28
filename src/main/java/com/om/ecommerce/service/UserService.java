package com.om.ecommerce.service;

import com.om.ecommerce.Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.om.ecommerce.entity.User;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo){
        this.repo=repo;
    }

    public User register(User user){
        User existingUser= repo.findByEmail(user.getEmail());

        if(existingUser!= null){
            return null;
        }

        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        String hashed= encoder.encode(user.getPassword());
        user.setPassword(hashed);

        user.setRole("USER");

        return repo.save(user);
    }

    public User login(String email, String password){
        User user=repo.findByEmail(email);

        if (user == null) {
            return null;
        }

        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

        if(!encoder.matches(password, user.getPassword())){
            return null;
        }

        return user;


    }
}
