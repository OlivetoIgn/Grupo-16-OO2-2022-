package com.unla.aulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.aulas.entity.ReservationEntity;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer>{

    public ReservationEntity findById(int id);

}
