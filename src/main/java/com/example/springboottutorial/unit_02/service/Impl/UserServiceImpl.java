package com.example.springboottutorial.unit_02.service.Impl;

import com.example.springboottutorial.unit_02.entity.User;
import com.example.springboottutorial.unit_02.repository.UserRepository;
import com.example.springboottutorial.unit_02.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
