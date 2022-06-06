package com.unla.aulas.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.aulas.entity.ClassroomEntity;
import com.unla.aulas.service.ClassroomService;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {
	@Autowired
	private ClassroomService classroomService;

	public ClassroomController(ClassroomService classroomService) {
		this.classroomService = classroomService;
	}

	@GetMapping()
	public ArrayList<ClassroomEntity> getAll() {
		return this.classroomService.getAllClassrooms();
	}

	@PostMapping()
	public String insertOrUpdate(@RequestBody ClassroomEntity classroomEntity) {
		boolean response = classroomService.insertOrUpdateClassroom(classroomEntity);
		String message;
		if (!response)
			message = "Ya existe el aula";
		else
			message = "Se creo correctamente";
		return message;
	}

	@GetMapping(path = "{id}")
	public ClassroomEntity getById(@PathVariable("id") int id) {
		return classroomService.getClassroomById(id);
	}

	@DeleteMapping(path = "{id}")
	public String delete(@PathVariable("id") int id) {
		String message;
		boolean response = classroomService.deleteClassroom(id);
		if (response)
			message = "Se ha eliminado el aula";
		else
			message = "No existe el id " + id;
		return message;
	}

}
