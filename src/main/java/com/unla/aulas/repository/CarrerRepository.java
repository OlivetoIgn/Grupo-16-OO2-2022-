package com.unla.aulas.repository;

import com.unla.aulas.entity.CarrerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrerRepository extends JpaRepository<CarrerEntity, Integer> {
    public abstract CarrerEntity findByCarrer(String carrer);
}
