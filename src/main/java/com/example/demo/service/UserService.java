package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;

	public User createUser(User user) {
        return userRepository.save(user);
    }
    
    public Optional<User> getUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }    
}