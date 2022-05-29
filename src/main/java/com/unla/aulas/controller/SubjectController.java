package com.unla.aulas.controller;

import com.unla.aulas.entity.SubjectEntity;
import com.unla.aulas.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("/save")
    public SubjectEntity saveSubject(@RequestBody SubjectEntity json){
        return this.subjectService.saveSubject(json);
    }

    @GetMapping("/query")
    public ArrayList<SubjectEntity> getSubjects(){
        return this.subjectService.getSubjects();
    }

    @GetMapping(path = "/{id}")
    public Optional<SubjectEntity> getSubject(@PathVariable("id") int id){
        return this.subjectService.getSubjectById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteSubject(@PathVariable("id") int id){
        boolean ok = this.subjectService.deleteSubject(id);
        if(ok){
            return "Se ha borrado con exito";
        }else {
            return "No existe el id " + id;
        }
    }

}
