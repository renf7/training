package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    
    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity<UserDto> login(@RequestParam String login, @RequestParam String password) {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}