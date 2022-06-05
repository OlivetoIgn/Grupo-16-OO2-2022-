package com.unla.aulas.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unla.aulas.dto.DepartmentDto;
import com.unla.aulas.entity.DepartmentEntity;
import com.unla.aulas.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/department/")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService = new DepartmentService();

    @PostMapping()
    public String saveDepartment(@RequestBody DepartmentDto json){
        boolean resp = departmentService.saveDepartment(json);
        if(!resp){
            return "Ya existe el departamento " + json.getDepartment();
        }else{
            return "Se creo correctamente";
        }
    }

    @GetMapping()
    public ArrayList<DepartmentEntity> getDepartments(){
        return this.departmentService.getDepartments();
    }

    @GetMapping(path = "{id}")
    public DepartmentDto getDepartment(@PathVariable("id") int id){
        return this.departmentService.getDepartment(id);
    }

    @DeleteMapping(path = "{id}")
    public String deleteDepartment(@PathVariable("id") int id){
        boolean ok = this.departmentService.deleteDepartment(id);
        if(ok){
            return "Se ha borrado con exito";
        }else {
            return "No existe el id " + id;
        }
    }
}
