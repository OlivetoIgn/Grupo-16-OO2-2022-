package com.unla.aulas.service;

import com.unla.aulas.entity.SubjectEntity;
import com.unla.aulas.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public SubjectEntity saveSubject(SubjectEntity subject){
        return subjectRepository.save(subject);
    }

    public ArrayList<SubjectEntity> getSubjects(){
        return (ArrayList<SubjectEntity>) subjectRepository.findAll();
    }

    public Optional<SubjectEntity> getSubjectById(int id){
        return subjectRepository.findById(id);
    }

    public SubjectEntity getSubject(String subject){
        return subjectRepository.findBySubject(subject);
    }

    public SubjectEntity getSubjectBySubjectCode(int subjectCode){
        return subjectRepository.findBySubject(subjectCode);
    }

    public boolean deleteSubject(int id){
        try{
            subjectRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
