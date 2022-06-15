package com.unla.aulas.service;

import com.unla.aulas.dto.*;
import com.unla.aulas.entity.SolicitudeEntity;
import com.unla.aulas.repository.SolicitudeRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudeService {

    @Autowired
    SolicitudeRepository solicitudeRepository;
    @Autowired
    SubjectService subjectService;
    @Autowired
    ClassroomService classroomService;

    @Autowired
    ReservationService reservationService;

    public ArrayList<SolicitudeEntity> getSolicitudesEntity(){
        return (ArrayList<SolicitudeEntity>) solicitudeRepository.findAll();
    }

    public ArrayList<SolicitudeEntity> getSolicitudes(){
        List<SolicitudeEntity> lstSolicitudEntities = solicitudeRepository.findAll();
        /*List<SolicitudeDto> lstSolicitudDto = new ArrayList<>();
        for (SolicitudeEntity solicitudEnt: lstSolicitudEntities) {
            SolicitudeDto solicitudeDto = new SolicitudeDto();
            solicitudeDto.setSolicitudeCode(solicitudEnt.getSolicitudeCode());
            solicitudeDto.setSolicitudeDate(solicitudEnt.getSolicitudeDate());
            solicitudeDto.setObservations(solicitudEnt.getObservations());
            solicitudeDto.setStartDate(solicitudEnt.getStartDate());
            solicitudeDto.setEndDate(solicitudEnt.getEndDate());
            solicitudeDto.setStudentsQuantity(solicitudEnt.getStudentsQuantity());
            solicitudeDto.setClassroomDto(classroomService.getClassroomDtoById(solicitudEnt.getClassroomEntity().getId()));
            solicitudeDto.setShiftDto(solicitudEnt.getShiftEntity());
            solicitudeDto.setSubjectDto(new SubjectDto(solicitudEnt.getId()));
            solicitudeDto.setTypeSolicitude(solicitudEnt.getTypeSolicitude());
            lstSolicitudDto.add(solicitudeDto);
        }*/
        return (ArrayList<SolicitudeEntity>) solicitudeRepository.findAll();
    }

    public Optional<SolicitudeEntity> getSolicitudeById(int id){

        return solicitudeRepository.findById(id);
    }

    public ArrayList<SolicitudeEntity> getSolicitudeBySolicitudDate(LocalDate solicitudeDate){

        return (ArrayList<SolicitudeEntity>)solicitudeRepository.findSolicitudeBySolicitudeDate(solicitudeDate);
    }

    /*public SolicitudeEntity getSolicitudByCode(int solicitudCode){
        return solicitudeRepository.findSolicitudeByCode(solicitudCode);
    }*/

    public SolicitudeDto saveSolicitude(SolicitudeDto solicitudeDto){
        SolicitudeEntity solicitudeEntity = new SolicitudeEntity();
        solicitudeEntity.setSolicitudeCode(solicitudeDto.getSolicitudeCode());
        solicitudeEntity.setSolicitudeDate(solicitudeDto.getSolicitudeDate());
        solicitudeEntity.setObservations(solicitudeDto.getObservations());
        solicitudeEntity.setStartDate(solicitudeDto.getStartDate());
        solicitudeEntity.setEndDate(solicitudeDto.getEndDate());
        solicitudeEntity.setShiftEntity(solicitudeDto.getShiftDto());
        solicitudeEntity.setStudentsQuantity(solicitudeDto.getStudentsQuantity());
        solicitudeEntity.setClassroomEntity(classroomService.getClassroomById(solicitudeDto.getClassroomDto().getId()).get());
        solicitudeEntity.setSubjectEntity(subjectService.getSubjectByIdEntity(solicitudeDto.getSubjectDto().getId()).get());
        ArrayList<SolicitudeEntity> lstSolicitudes = getSolicitudesEntity();
        for (SolicitudeEntity solicitude : lstSolicitudes) {
            if(solicitudeEntity.equals(solicitude)){
                return null;
            }
        }
        ArrayList<LocalDate> lstDaysToReserve = new ArrayList<>();
        LocalDate aux = solicitudeDto.getStartDate();
        if(aux.equals(solicitudeDto.getEndDate())){
            lstDaysToReserve.add(aux);
        }
        while (!aux.isEqual(solicitudeDto.getEndDate()))
        {
            lstDaysToReserve.add(aux);
            aux = Funciones.traerFechaProximo(aux, 7);
        }
        for(LocalDate date:lstDaysToReserve) {
            if(Funciones.esDiaHabil(date)){
                ReservationDto reservationDto = new ReservationDto();
                reservationDto.setReservationDate(date);
                reservationDto.setShiftDto(solicitudeDto.getShiftDto());
                reservationDto.setTaken(true);
                reservationDto.setClassroomDto(solicitudeDto.getClassroomDto());
                reservationService.insertOrUpdateReservation(reservationDto);
            }
        }
        solicitudeRepository.save(solicitudeEntity);
        return solicitudeDto;
    }

    public boolean deleteSolicitude(int id){
        try{
            solicitudeRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
