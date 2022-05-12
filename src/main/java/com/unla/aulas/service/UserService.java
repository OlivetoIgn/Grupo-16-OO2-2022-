package com.unla.aulas.service;

import com.unla.aulas.entity.RoleEntity;
import com.unla.aulas.entity.UserEntity;
import com.unla.aulas.repository.RoleRepository;
import com.unla.aulas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;


    @Service
    public class UserService {

        private UserRepository userRepository;
        private RoleRepository roleRepository;
        private BCryptPasswordEncoder bCryptPasswordEncoder;

        @Autowired
        public UserService(UserRepository userRepository,
                           RoleRepository roleRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
            this.userRepository = userRepository;
            this.roleRepository = roleRepository;
            this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        }

        public UserEntity findUserByEmail(String email) {
            return userRepository.findByEmail(email);
        }

        public UserEntity findUserByUserName(String userName) {
            return userRepository.findByUserName(userName);
        }

        public UserEntity saveUser(UserEntity user) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setActive(true);
            RoleEntity userRole = roleRepository.findByRole("ADMIN");
            user.setRoles(new HashSet<>(Arrays.asList(userRole)));
            return userRepository.save(user);
        }

}