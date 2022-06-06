package com.unla.aulas.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.aulas.dto.BuildingDto;
import com.unla.aulas.entity.BuildingEntity;
import com.unla.aulas.service.BuildingService;

@RestController
@RequestMapping("/building")
public class BuildingController {
	@Autowired
	private BuildingService buildingService;

	public BuildingController(BuildingService buildingService) {
		this.buildingService = buildingService;
	}

	@GetMapping()
	public ArrayList<BuildingEntity> getAll() {
		return this.buildingService.getAllBuildings();
	}

	@PostMapping()
	public String insertOrUpdate(@RequestBody BuildingDto buildingDto) {
		boolean response = buildingService.insertOrUpdateBuilding(buildingDto);
		String message;
		if (!response) {
			message = "Ya existe el edificio " + buildingDto.getBuilding();
		} else {
			message = "Se creo correctamente";
		}
		return message;
	}

	@GetMapping(path = "{id}")
	public Optional<BuildingEntity> getById(@PathVariable("id") int id) {
		return buildingService.getBuildingById(id);
	}

	@DeleteMapping(path = "{id}")
	public String delete(@PathVariable("id") int id) {
		String message;
		boolean response = buildingService.deleteBuilding(id);
		if (response)
			message = "Se ha eliminado el edificio";
		else
			message = "No existe el id " + id;
		return message;
	}

}
