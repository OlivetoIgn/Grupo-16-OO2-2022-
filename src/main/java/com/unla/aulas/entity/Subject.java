package com.unla.aulas.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "subject_code")
    private int subjectCode;
    @Column(name = "subject")
    private String subject;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carrer_id")
    private Carrer carrer;

    public Subject(int subjectCode, String subject, Carrer carrer) {
        this.subjectCode = subjectCode;
        this.subject = subject;
        this.carrer = carrer;
    }

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

    public Carrer getCarrer() {
        return carrer;
    }

    public void setCarrer(Carrer carrer) {
        this.carrer = carrer;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjectCode=" + subjectCode +
                ", subject='" + subject + '\'' +
                ", carrer=" + carrer +
                '}';
    }
}
