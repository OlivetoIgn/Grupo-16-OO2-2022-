package com.unla.aulas.service;

import com.unla.aulas.entity.RoleEntity;
import com.unla.aulas.entity.UserEntity;
import com.unla.aulas.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

import static java.util.Collections.emptyList;

@Service
public class UserEntityAuthService implements UserDetailsService {
    private UserRepository userRepository;

    public UserEntityAuthService( UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByUserName(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(userEntity.getUserName(), userEntity.getPassword(), createAuthorities(userEntity));
    }

    private Collection<GrantedAuthority> createAuthorities(UserEntity userEntity) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity roleEntity: userEntity.getRoles()
        ) {
            authorities.add(new SimpleGrantedAuthority(roleEntity.getName()));

        }

        return  authorities;
    }
}