package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.demo.config.security.JwtTokenProvider;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private UserService userService;
    private JwtTokenProvider jwtTokenProvider;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<UserDto> login(@RequestParam String login, @RequestParam String password) {
        Optional<User> user = userService.getUserByUserName(login);
        if (user.isPresent()) {
            Set<Role> roles = user.get().getAuthorities();
            String token = jwtTokenProvider.createToken(login, roles);
            UserDto userDto = new UserDto();
            userDto.setUsername(login);
            userDto.setToken(token);
            userDto.setId(user.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body(userDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}