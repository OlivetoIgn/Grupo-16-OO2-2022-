package com.unla.aulas.service;

import com.unla.aulas.dto.CarrerDto;
import com.unla.aulas.dto.DepartmentDto;
import com.unla.aulas.entity.CarrerEntity;
import com.unla.aulas.entity.DepartmentEntity;
import com.unla.aulas.repository.CarrerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CarrerService {

    @Autowired
    CarrerRepository carrerRepository;
    DepartmentService departmentService = new DepartmentService();

    public CarrerEntity saveCarrer(CarrerDto carrer){
        DepartmentDto departmentDto = departmentService.getDepartment(carrer.getDepartment().getDepartment());
        DepartmentEntity departmentEntity = new DepartmentEntity(departmentDto.getDepartment());
        CarrerEntity carrerEntity = new CarrerEntity(carrer.getCarrer(), departmentEntity);
        return carrerRepository.save(carrerEntity);
    }

    public ArrayList<CarrerEntity> getCarrers(){
        return (ArrayList<CarrerEntity>)carrerRepository.findAll();
    }

    public CarrerDto getCarrer(String carrer){
        CarrerEntity carrerEntity = carrerRepository.findByCarrer(carrer);
        return new CarrerDto(carrerEntity.getCarrer(), new DepartmentDto(carrerEntity.getDepartment().getDepartment()));
    }

    public Optional<CarrerEntity> getCarrer(int id){
        return carrerRepository.findById(id);
    }

    public boolean deleteCarrer(int id){
        try{
            carrerRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
