package com.unla.aulas.controller;

import com.unla.aulas.dto.CarrerDto;
import com.unla.aulas.entity.CarrerEntity;
import com.unla.aulas.service.CarrerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/carrer/")
public class CarrerController {

    @Autowired
    CarrerService carrerService;

    @PostMapping("save")
    public String saveCarrer(@RequestBody CarrerDto json){
        boolean resp = carrerService.saveCarrer(json);
        if(!resp){
            return "Ya existe la carrera " + json.getCarrer();
        }else {
            return "Se creo correctamente";
        }
    }

    @GetMapping( path = "{id}")
    public Optional<CarrerEntity> getCarrerPorId(@PathVariable("id") int id){
        return this.carrerService.getCarrer(id);
    }

    @GetMapping("query")
    public ArrayList<CarrerEntity> getCarrers(){
        return this.carrerService.getCarrers();
    }

    @DeleteMapping(path = "{id}")
    public String deleteCarrer(@PathVariable("id") int id){
        boolean ok = this.carrerService.deleteCarrer(id);
        if(ok){
            return "Se ha borrado con exito";
        }else {
            return "No existe el id " + id;
        }
    }
}
