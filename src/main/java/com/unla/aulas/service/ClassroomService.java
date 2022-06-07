package com.unla.aulas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.unla.aulas.entity.ClassroomEntity;
import com.unla.aulas.entity.ReservationEntity;
import com.unla.aulas.repository.ClassroomRepository;

@Service
public class ClassroomService  {
    @Lazy
    @Autowired
    private ClassroomRepository classroomRepository;


    @Lazy
    @Autowired
    private ReservationService reservationService;

    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }


    public ArrayList<ClassroomEntity> getAllClassrooms() {
        return (ArrayList<ClassroomEntity>) classroomRepository.findAll();
    }


    public boolean insertOrUpdateClassroom(ClassroomEntity classroomEntity) {
        classroomRepository.save(classroomEntity);
        return true;
    }


    public ClassroomEntity getClassroomById(int id) {
        return classroomRepository.findById(id);
    }


    public boolean deleteClassroom(int id) {
        try {
            classroomRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public ClassroomEntity getClassroomEntityById(int id) {
        ClassroomEntity classroomEntity = classroomRepository.findById(id);
        return classroomEntity;
    }


    public ClassroomEntity getClassroomEntityByNumber(int number) {
        ClassroomEntity classroomEntity = classroomRepository.findByNumber(number);
        return classroomEntity;
    }

    public List<ReservationEntity> getReservation(int id) {
        return classroomRepository.findByReservations(id);
    }


}
