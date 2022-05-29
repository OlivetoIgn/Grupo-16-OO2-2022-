package com.unla.aulas.repository;

import com.unla.aulas.entity.SolicitudeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;

@Repository
public interface SolicitudeRepository extends JpaRepository<SolicitudeEntity, Integer> {

    public abstract ArrayList<SolicitudeEntity> findSolicitudeByShift(String shift);

    public abstract ArrayList<SolicitudeEntity> findSolicitudeBySolicitudeDate(LocalDate solicitudeDate);
}
