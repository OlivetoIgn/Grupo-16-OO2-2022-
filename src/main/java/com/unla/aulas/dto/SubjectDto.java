package com.unla.aulas.dto;

import com.unla.aulas.entity.CarrerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto {

    private int id;
    private int subjectCode;
    private String subject;
    private CarrerDto carrer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(int subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public CarrerDto getCarrer() {
        return carrer;
    }

    public void setCarrer(CarrerDto carrer) {
        this.carrer = carrer;
    }
}
