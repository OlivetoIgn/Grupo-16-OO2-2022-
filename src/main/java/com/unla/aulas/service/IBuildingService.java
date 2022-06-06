package com.unla.aulas.service;

import java.util.ArrayList;
import java.util.Optional;

import com.unla.aulas.dto.BuildingDto;
import com.unla.aulas.entity.BuildingEntity;


public interface IBuildingService {
  public ArrayList<BuildingEntity> getAllBuildings();
  
  public boolean insertOrUpdateBuilding(BuildingDto buildingDto);
  
  public Optional<BuildingEntity> getBuildingById(int id);
  
  public boolean deleteBuilding(int id);

}
