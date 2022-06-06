package com.unla.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.unla.entity.Building;
import com.unla.repository.BuildingRepository;



public class BuildingController {
	private Logger logger = LoggerFactory.getLogger(ClassroomController.class);
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	@GetMapping("/buildings")
	public ResponseEntity<Object> getAllCustomers(){
		try {
			Iterable<Building> buildings = buildingRepository.findAll();
			return new ResponseEntity<Object>(buildings, HttpStatus.OK);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/buildings/{id}")
	public ResponseEntity<Object> getCustomerById(@PathVariable("id") Long id) {
		try {
			Building building = buildingRepository.findById(id).get();
			if(building != null) {
				return new ResponseEntity<Object>(building, HttpStatus.OK);				
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/buildings")
	public ResponseEntity<Object> createCustomer(@RequestBody Building building) {
		try {
			Building savedBuilding = buildingRepository.save(building);
			return new ResponseEntity<Object>(savedBuilding, HttpStatus.OK);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/buildings/{id}")
	public ResponseEntity<Object> updateCustomer(@PathVariable("id") Long id, @RequestBody Building building) {
		try {
			building.setId(id);
			Building savedBuilding = buildingRepository.save(building);
			return new ResponseEntity<Object>(savedBuilding, HttpStatus.OK);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/buildings/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") Long id) {
		try {
			buildingRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}
}
