package com.unla.aulas.repository;

import com.unla.aulas.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
    public abstract DepartmentEntity findByDepartment(String department);
}
