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
        if(departmentEntity != null){
            DepartmentDto departmentDto = new DepartmentDto(departmentEntity.getId(), departmentEntity.getDepartment());
            return departmentDto;
        }else{
            return null;
        }
    }

    public DepartmentEntity getDepartmentEntity(String department){
        DepartmentEntity departmentEntity = departmentRepository.findByDepartment(department);
        return departmentEntity;
    }

    public DepartmentDto getDepartment(int id){
        Optional<DepartmentEntity> departmentEntity = null;
        departmentEntity = departmentRepository.findById(id);
        return new DepartmentDto(departmentEntity.get().getId(), departmentEntity.get().getDepartment());
    }

    public boolean saveDepartment(DepartmentDto departmentDto){
        DepartmentDto existDepartment = getDepartment(departmentDto.getDepartment());
        if(existDepartment != null){
            return false;
        }else{
            DepartmentEntity departmentEntity = new DepartmentEntity();
            departmentEntity.setDepartment(departmentDto.getDepartment());
            departmentRepository.save(departmentEntity);
            return true;
        }
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
