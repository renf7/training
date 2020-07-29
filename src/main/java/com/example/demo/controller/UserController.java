package com.example.demo.controller;

import com.example.demo.converter.UserConverter;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserConverter userConverter;
    
    @PostMapping
    public ResponseEntity<UserDto> register(@RequestBody UserDto dto) {
        User user = userConverter.dto2db(dto);
        User savedUser = userService.createUser(user);
        log.info("get request {}", user);
        dto = userConverter.db2Dto(savedUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}