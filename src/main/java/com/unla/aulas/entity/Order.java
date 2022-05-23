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
@Table(name="order")
public abstract class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "shift")//Turno
    private String shift;
    @Column(name = "students_quantity")
    private int studentsQuantity;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Subject subject;
    @Column(name = "observations")
    private String observations;

    public Order(LocalDate date, String shift, int studentsQuantity, Subject subject, String observations) {
        this.date = date;
        this.shift = shift;
        this.studentsQuantity = studentsQuantity;
        this.subject = subject;
        this.observations = observations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public int getStudentsQuantity() {
        return studentsQuantity;
    }

    public void setStudentsQuantity(int studentsQuantity) {
        this.studentsQuantity = studentsQuantity;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", shift='" + shift + '\'' +
                ", studentsQuantity=" + studentsQuantity +
                ", subject=" + subject +
                ", observations='" + observations + '\'' +
                '}';
    }

}
