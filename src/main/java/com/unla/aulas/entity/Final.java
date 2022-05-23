package com.unla.aulas.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="final")
public class Final extends Order{
    @Column(name = "date_exam")
    private LocalDate dateExam;

    public Final(LocalDate date, String shift, int studentsQuantity, Subject subject, String observations, LocalDate dateExam) {
        super(date, shift, studentsQuantity, subject, observations);
        this.dateExam = dateExam;
    }

    public LocalDate getDateExam() {
        return dateExam;
    }

    public void setExamDate(LocalDate dateExam) {
        this.dateExam = dateExam;
    }

    public String toString() {
        return "Final{" +
                "dateExam=" + dateExam +
                "} " + super.toString();
    }


}
