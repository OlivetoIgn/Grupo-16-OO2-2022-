package com.unla.aulas.service;

import com.unla.aulas.entity.UserEntity;
import com.unla.aulas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getAll()
    {
        return userRepository.findAll();
    }

    public UserEntity saveUser(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    public Optional<UserEntity> getUserById(int id){
        return userRepository.findById(id);
    }

    public UserEntity getUserByUsername(String userName){
        return userRepository.findOneByUserName(userName);
    }

    public boolean deleteUserById(int id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
