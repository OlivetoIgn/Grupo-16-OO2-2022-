package com.unla.aulas.service;

import com.unla.aulas.dto.DepartmentDto;
import com.unla.aulas.entity.DepartmentEntity;
import com.unla.aulas.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public ArrayList<DepartmentEntity> getDepartments(){
        return (ArrayList<DepartmentEntity>)departmentRepository.findAll();
    }

    public DepartmentDto getDepartment(String department){
        DepartmentEntity departmentEntity = departmentRepository.findByDepartment(department);
        DepartmentDto departmentDto = new DepartmentDto(departmentEntity.getDepartment());
        return departmentDto;
    }

    public DepartmentDto getDepartment(int id){
        Optional<DepartmentEntity> departmentEntity = null;
        departmentEntity = departmentRepository.findById(id);
        return new DepartmentDto(departmentEntity.get().getDepartment());
    }

    public DepartmentEntity saveDepartment(DepartmentDto departmentDto){
        return departmentRepository.save(new DepartmentEntity(departmentDto.getDepartment()));
    }

    public boolean deleteDepartment(int id){
        try{
            departmentRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
