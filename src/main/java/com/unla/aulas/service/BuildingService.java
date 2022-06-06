package com.unla.aulas.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.aulas.dto.BuildingDto;
import com.unla.aulas.entity.BuildingEntity;
import com.unla.aulas.repository.BuildingRepository;

@Service
public class BuildingService implements IBuildingService {
	@Autowired
	private BuildingRepository buildingRepository;

	public BuildingService(BuildingRepository buildingRepository) {
		this.buildingRepository = buildingRepository;
	}

	@Override
	public ArrayList<BuildingEntity> getAllBuildings() {
		return (ArrayList<BuildingEntity>) buildingRepository.findAll();
	}

	@Override
	public boolean insertOrUpdateBuilding(BuildingDto buildingDto) {
		boolean flag; 
		BuildingEntity building = getBuildingEntity(buildingDto.getBuilding());

		if (building != null) {
			 flag = false;
		}else {
			BuildingEntity buildingEntity = new BuildingEntity();
			buildingEntity.setBuilding(buildingDto.getBuilding());
			buildingEntity.setId(buildingDto.getId());
			buildingRepository.save(buildingEntity);
			flag = true;
		}
		return flag;
	}

	@Override
	public Optional<BuildingEntity> getBuildingById(int id) {
		return buildingRepository.findById(id);
	}

	@Override
	public boolean deleteBuilding(int id) {
		try {
			buildingRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public BuildingEntity getBuildingEntity(String building) {
		BuildingEntity buildingEntity = buildingRepository.findByBuilding(building);
		return buildingEntity;
	}
}
