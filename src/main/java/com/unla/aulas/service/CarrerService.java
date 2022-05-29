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
    @Autowired
    DepartmentService departmentService = new DepartmentService();

    public boolean saveCarrer(CarrerDto carrer){
        CarrerEntity existCarrer = getCarrerEntity(carrer.getCarrer());
        if(existCarrer != null){
            return false;
        }
        else {
            DepartmentEntity departmentEntity = departmentService.getDepartmentEntity(carrer.getDepartment().getDepartment());
            if(departmentEntity == null){
                return false;
            }
            CarrerEntity carrerEntity = new CarrerEntity();
            carrerEntity.setCarrer(carrer.getCarrer());
            carrerEntity.setDepartment(departmentEntity);
            carrerRepository.save(carrerEntity);
            return true;
        }
    }

    public ArrayList<CarrerEntity> getCarrers(){
        return (ArrayList<CarrerEntity>)carrerRepository.findAll();
    }

    public CarrerDto getCarrer(String carrer){
        CarrerEntity carrerEntity = carrerRepository.findByCarrer(carrer);
        return new CarrerDto(carrerEntity.getCarrer(), new DepartmentDto(carrerEntity.getDepartment().getId(), carrerEntity.getDepartment().getDepartment()));
    }

    public CarrerEntity getCarrerEntity(String carrer){
        CarrerEntity carrerEntity = carrerRepository.findByCarrer(carrer);
        return carrerEntity;
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
