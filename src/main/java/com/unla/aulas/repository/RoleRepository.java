package com.unla.aulas.repository;

import com.unla.aulas.entity.RoleEntity;
import com.unla.aulas.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
}
