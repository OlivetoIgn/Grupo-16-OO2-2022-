package com.unla.aulas.controller;

import com.unla.aulas.dto.UserDto;
import com.unla.aulas.entity.UserEntity;
import com.unla.aulas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<UserEntity> findAll()  {

        List<UserEntity> users = userRepository.findAll();

        return users;
    }

    @PostMapping
    public void signUp(@RequestBody UserDto userDto) {
        String encryptedPassword = bCryptPasswordEncoder.encode(userDto.getPassword());

        userRepository.save(UserEntity.builder().userName(userDto.getUserName()).password(encryptedPassword).build());
    }
}
