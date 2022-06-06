package com.unla.aulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.aulas.entity.BuildingEntity;

@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity, Integer> {

	public abstract BuildingEntity findByBuilding(String building);

}