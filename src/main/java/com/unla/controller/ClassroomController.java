package com.unla.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.entity.Classroom;
import com.unla.repository.ClassroomRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ClassroomController {
	private Logger logger = LoggerFactory.getLogger(ClassroomController.class);
	
	@Autowired
	private ClassroomRepository classroomRepository;
	
	@GetMapping("/classrooms")
	public ResponseEntity<Object> getAllCustomers(){
		try {
			Iterable<Classroom> classrooms = classroomRepository.findAll();
			return new ResponseEntity<Object>(classrooms, HttpStatus.OK);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Object> getCustomerById(@PathVariable("id") Long id) {
		try {
			Classroom classroom = classroomRepository.findById(id).get();
			if(classroom != null) {
				return new ResponseEntity<Object>(classroom, HttpStatus.OK);				
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/classrooms")
	public ResponseEntity<Object> createCustomer(@RequestBody Classroom classroom) {
		try {
			Classroom savedClassroom = classroomRepository.save(classroom);
			return new ResponseEntity<Object>(savedClassroom, HttpStatus.OK);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/classrooms/{id}")
	public ResponseEntity<Object> updateCustomer(@PathVariable("id") Long id, @RequestBody Classroom classroom) {
		try {
			classroom.setId(id);
			Classroom savedClassroom = classroomRepository.save(classroom);
			return new ResponseEntity<Object>(savedClassroom, HttpStatus.OK);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/classrooms/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") Long id) {
		try {
			classroomRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}
}
