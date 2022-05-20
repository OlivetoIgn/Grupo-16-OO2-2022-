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

import com.unla.entity.Space;
import com.unla.repository.SpaceRepository;



public class SpaceController {
	private Logger logger = LoggerFactory.getLogger(ClassroomController.class);
	
	@Autowired
	private SpaceRepository spaceRepository;
	
	@GetMapping("/spaces")
	public ResponseEntity<Object> getAllCustomers(){
		try {
			Iterable<Space> spaces = spaceRepository.findAll();
			return new ResponseEntity<Object>(spaces, HttpStatus.OK);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/spaces/{id}")
	public ResponseEntity<Object> getCustomerById(@PathVariable("id") Long id) {
		try {
			Space space = spaceRepository.findById(id).get();
			if(space != null) {
				return new ResponseEntity<Object>(space, HttpStatus.OK);				
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/spaces")
	public ResponseEntity<Object> createCustomer(@RequestBody Space space) {
		try {
			Space savedSpace = spaceRepository.save(space);
			return new ResponseEntity<Object>(savedSpace, HttpStatus.OK);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/spaces/{id}")
	public ResponseEntity<Object> updateCustomer(@PathVariable("id") Long id, @RequestBody Space space) {
		try {
			space.setId(id);
			Space savedClassroom = spaceRepository.save(space);
			return new ResponseEntity<Object>(savedClassroom, HttpStatus.OK);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/spaces/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") Long id) {
		try {
			spaceRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}
}
