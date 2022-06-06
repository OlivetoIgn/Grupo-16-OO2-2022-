package com.unla.aulas.controller;

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
    public String saveSolicitude(@RequestBody SolicitudeEntity solicitudeEntity){
        boolean resp = solicitudeService.saveSolicitude(solicitudeEntity);
        if(resp){
            return "Se creo correctamente";
        }
        return "No se pudo crear el pedido";
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
