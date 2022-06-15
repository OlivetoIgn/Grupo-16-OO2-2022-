package com.unla.aulas.controller;

import com.unla.aulas.dto.SolicitudeDto;
import com.unla.aulas.entity.SolicitudeEntity;
import com.unla.aulas.service.SolicitudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/solicitude/")
public class SolicitudeController {

    @Autowired
    SolicitudeService solicitudeService;

    @GetMapping()
    public ArrayList<SolicitudeEntity> getSolicitudes(){
        return solicitudeService.getSolicitudes();
    }

    @PostMapping()
    public SolicitudeDto saveSolicitude(@RequestBody SolicitudeDto solicitudeDto){
        return solicitudeService.saveSolicitude(solicitudeDto);
    }

    @GetMapping("{id}")
    public Optional<SolicitudeEntity> getSolicitude(@PathVariable("id") int id){
        return solicitudeService.getSolicitudeById(id);
    }

    @DeleteMapping("{id}")
    public String deleteSolicitude(@PathVariable("id") int id){
        boolean resp = solicitudeService.deleteSolicitude(id);
        if(resp){
            return "Se borro con exito";
        }else {
            return "No se pudo borrar";
        }
    }


}
