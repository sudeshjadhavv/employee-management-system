package com.example.ems.services;


import com.example.ems.entities.User;

public interface UserService {
    User registerUser(User user);  
    
    User findByUsername(String username);
}
