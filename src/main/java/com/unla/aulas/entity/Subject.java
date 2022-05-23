package com.unla.aulas.entity;

public class Subject {
    private int id;
    private int subjectCode;
    private String subject;
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
