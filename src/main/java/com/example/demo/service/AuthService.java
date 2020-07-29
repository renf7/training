package com.example.demo.service;

import static java.lang.String.format;

import java.util.Optional;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService implements UserDetailsService {
    private static final String ERROR_MSG_CANNOT_FIND_USER_BY_NAME = "Cannot find user by name {}";
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isEmpty()) {
            throw new UsernameNotFoundException(format(ERROR_MSG_CANNOT_FIND_USER_BY_NAME, username));
        }
        return userOpt.get();
    }
    
}