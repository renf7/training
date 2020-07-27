package com.example.demo.converter;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UserConverter {
    private final ModelMapper modelMapper;
    
    public User dto2db(UserDto dto) {
        return modelMapper.map(dto, User.class);
    }
    
    public UserDto db2Dto(User db) {
        return modelMapper.map(db, UserDto.class);
    }
}