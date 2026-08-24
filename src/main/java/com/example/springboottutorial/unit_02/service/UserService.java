package com.example.springboottutorial.unit_02.service;

import com.example.springboottutorial.unit_02.UserDto.UserDto;
import com.example.springboottutorial.unit_02.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUserById(Long id);
}
