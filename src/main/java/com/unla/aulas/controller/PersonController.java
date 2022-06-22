package com.unla.aulas.controller;


import com.unla.aulas.entity.ClassroomEntity;
import com.unla.aulas.entity.RoleEntity;
import com.unla.aulas.entity.UserEntity;
import com.unla.aulas.repository.RoleRepository;
import com.unla.aulas.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person/")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping
    public List<UserEntity> findAll()  {
        List<UserEntity> users = personService.getAll();
        return users;
    }

    @PostMapping()
    public UserEntity saveUser(@RequestBody UserEntity json){
        return personService.saveUser(json);
    }

    @GetMapping(path = "{id}")
    public Optional<UserEntity> getById(@PathVariable("id") int id) {
        return personService.getUserById(id);
    }

    @DeleteMapping(path = "{id}")
    public String delete(@PathVariable("id") int id) {
        String message;
        boolean response = personService.deleteUserById(id);
        if (response)
            message = "Se ha eliminado el usuario";
        else
            message = "No existe el id " + id;
        return message;
    }

    @GetMapping("userName/")
    public UserEntity getUserByUsername(@RequestBody UserEntity json){
        return personService.getUserByUsername(json.getUserName());
    }

    @GetMapping("roles/")
    public List<RoleEntity> getAllRoles(){
        return roleRepository.findAll();
    }
}
