package com.unla.aulas.service;

import com.unla.aulas.entity.SolicitudeEntity;
import com.unla.aulas.repository.SolicitudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class SolicitudeService {

    @Autowired
    SolicitudeRepository solicitudeRepository;

    public ArrayList<SolicitudeEntity> getSolicitudes(){
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

    public boolean saveSolicitude(SolicitudeEntity solicitudeEntity){
        ArrayList<SolicitudeEntity> lstSolicitudes = getSolicitudes();
        for (SolicitudeEntity solicitude : lstSolicitudes) {
            if(solicitudeEntity.equals(solicitude)){
                return false;
            }
        }
        solicitudeRepository.save(solicitudeEntity);
        return true;
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
