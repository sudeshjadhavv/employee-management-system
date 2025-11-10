package com.example.ems.services;

import com.example.ems.entities.User;

public interface AuthService {
    String register(User user);
    String login(String username, String password);
}